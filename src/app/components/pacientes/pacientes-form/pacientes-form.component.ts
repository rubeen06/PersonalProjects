import { Component, inject, OnInit } from '@angular/core';
import { PacienteService } from '../../../services/paciente.service';
import { Router, RouterModule } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Paciente } from '../../../models/paciente';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-pacientes-form',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './pacientes-form.component.html',
  styleUrl: './pacientes-form.component.css'
})
export default class PacientesFormComponent implements OnInit
{
  private pacienteService = inject(PacienteService);
  private fb = inject(FormBuilder);
  private router = inject(Router);
  private route = inject(ActivatedRoute);

  paciente?: Paciente;

  form?: FormGroup;
  formSubmitted = false;

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.pacienteService.getPacientes(parseInt(id)).subscribe(paciente => {
        this.paciente = paciente;
        this.form = this.fb.group({
          dni: [paciente.dni, [Validators.required, Validators.pattern(/^[0-9]{8}[A-Z]$/)]],
          nombre: [paciente.nombre, [Validators.required, Validators.minLength(2)]],
          apellido: [paciente.apellido, [Validators.required, Validators.minLength(2)]],
          diagnostico: [paciente.diagnostico, [Validators.required]],
        });
      })
    } else {
      this.form = this.fb.group({
        dni: ['', [Validators.required, Validators.pattern(/^[0-9]{8}[A-Z]$/)]],
        nombre: ['', [Validators.required, Validators.minLength(2)]],
        apellido: ['', [Validators.required, Validators.minLength(2)]],
        diagnostico: ['', [Validators.required]],
      });
    }
  }

  save() {
    this.formSubmitted = true;
    const pacienteFormValue = this.form!.value;
    console.log(pacienteFormValue);
  
    if (this.paciente) {
      // Crear un nuevo objeto Paciente con el id del paciente existente y los valores del formulario
      const updatedPaciente: Paciente = {
        ...this.paciente,
        dni: pacienteFormValue.dni,
        nombre: pacienteFormValue.nombre,
        apellido: pacienteFormValue.apellido,
        diagnostico: pacienteFormValue.diagnostico
      };
  
      this.pacienteService.updatePacientes(this.paciente.id, updatedPaciente).subscribe(() => {
        Swal.fire({
          title: 'Éxito',
          text: 'Paciente actualizado correctamente',
          icon: 'success',
          confirmButtonText: 'Aceptar'
        }).then(() => {
          this.router.navigate(['/doctores']);
        });
      });
    } else {
      this.pacienteService.crearPacientes(pacienteFormValue).subscribe(() => {
        Swal.fire({
          title: 'Éxito',
          text: 'Paciente creado correctamente',
          icon: 'success',
          confirmButtonText: 'Aceptar'
        }).then(() => {
          this.router.navigate(['/doctores']);
        });
      });
    }
  }

}
