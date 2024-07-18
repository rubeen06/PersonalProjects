import { Component, inject, OnInit } from '@angular/core';
import { DoctorService } from '../../../services/doctor.service';
import { EnfermeroService } from '../../../services/enfermero.service';
import { PacienteService } from '../../../services/paciente.service';
import { Router, RouterModule } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Enfermero } from '../../../models/enfermero';
import { Paciente } from '../../../models/paciente';
import { Doctor } from '../../../models/doctor';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-doctores-form',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './doctores-form.component.html',
  styleUrl: './doctores-form.component.css'
})
export default class DoctoresFormComponent implements OnInit {
  private doctorService = inject(DoctorService);
  private enfermeroService = inject(EnfermeroService);
  private pacienteService = inject(PacienteService);
  private fb = inject(FormBuilder);
  private router = inject(Router);
  private route = inject(ActivatedRoute);

  doctor?: Doctor;
  enfermeros: Enfermero[] = [];
  pacientes: Paciente[] = [];

  form?: FormGroup;
  formSubmitted = false;


  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.doctorService.getDoctor(parseInt(id)).subscribe(doctor => {
        this.doctor = doctor;
        this.form = this.fb.group({
          dni: [doctor.dni, [Validators.required, Validators.pattern(/^[0-9]{8}[A-Z]$/)]],
          nombre: [doctor.nombre, [Validators.required, Validators.minLength(2)]],
          apellido: [doctor.apellido, [Validators.required, Validators.minLength(2)]],
          especialidad: [doctor.especialidad, [Validators.required]],
          enfermeros: [doctor.enfermeros, [Validators.required]],
          pacientes: [doctor.pacientes, [Validators.required]]
        });
      })
    } else {
      this.form = this.fb.group({
        dni: ['', [Validators.required, Validators.pattern(/^[0-9]{8}[A-Z]$/)]],
        nombre: ['', [Validators.required, Validators.minLength(2)]],
        apellido: ['', [Validators.required, Validators.minLength(2)]],
        especialidad: ['', [Validators.required]],
        enfermeros: [[], [Validators.required]],
        pacientes: [[], [Validators.required]]
      });
    }
    this.enfermeroService.listEnfermeros().subscribe((enfermeros) => {
      this.enfermeros = enfermeros;
    })
    this.pacienteService.listPacientes().subscribe((pacientes) => {
      this.pacientes = pacientes;
    })
  }

  save() {
    this.formSubmitted = true;
    const doctor = this.form!.value;
    console.log(doctor);
    if (this.doctor) {
      this.doctorService.updateDoctor(this.doctor.id, doctor).subscribe(() => {
        Swal.fire({
          title: 'Éxito',
          text: 'Doctor actualizado correctamente',
          icon: 'success',
          confirmButtonText: 'Aceptar'
        }).then(() => {
          this.router.navigate(['/doctores']);
        });
      })
    } else {
      this.doctorService.crearDoctor(doctor).subscribe(() => {
        Swal.fire({
          title: 'Éxito',
          text: 'Doctor creado correctamente',
          icon: 'success',
          confirmButtonText: 'Aceptar'
        }).then(() => {
          this.router.navigate(['/doctores']);
        });
      });
    
    }
  }

}
