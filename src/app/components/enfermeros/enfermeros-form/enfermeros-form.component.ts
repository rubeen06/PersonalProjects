import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { DoctorService } from '../../../services/doctor.service';
import { EnfermeroService } from '../../../services/enfermero.service';
import { Enfermero } from '../../../models/enfermero';
import { Doctor } from '../../../models/doctor';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-enfermeros-form',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './enfermeros-form.component.html',
  styleUrl: './enfermeros-form.component.css'
})
export default class EnfermerosFormComponent implements OnInit{
  
  private doctorService = inject(DoctorService);
  private enfermeroService = inject(EnfermeroService);
  private fb = inject(FormBuilder);
  private router = inject(Router);
  private route = inject(ActivatedRoute);

  enfermero?: Enfermero;
  doctor?: Doctor;
  enfermeros: Enfermero[] = [];
  doctores: Doctor[] = [];

  form?: FormGroup;
  formSubmitted = false;


  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.enfermeroService.getEnfermero(parseInt(id)).subscribe(enfermero => {
        this.enfermero = enfermero;
        this.form = this.fb.group({
          dni: [enfermero.dni, [Validators.required, Validators.pattern(/^[0-9]{8}[A-Z]$/)]],
          nombre: [enfermero.nombre, [Validators.required, Validators.minLength(2)]],
          apellido: [enfermero.apellido, [Validators.required, Validators.minLength(2)]],
          turno: [enfermero.turno, [Validators.required]],
        });
      })
    } else {
      this.form = this.fb.group({
        dni: ['', [Validators.required, Validators.pattern(/^[0-9]{8}[A-Z]$/)]],
        nombre: ['', [Validators.required, Validators.minLength(2)]],
        apellido: ['', [Validators.required, Validators.minLength(2)]],
        turno: ['', [Validators.required]],
      });
    }
    this.doctorService.listDoctores().subscribe((doctores) => {
      this.doctores = doctores;
    })
  }

  save() {
    this.formSubmitted = true;

    const enfermeroFormValue = this.form!.value;
    console.log(enfermeroFormValue);

    if (this.enfermero) {
      // Crear un nuevo objeto Enfermero con el id del enfermero existente y los valores del formulario
      const updatedEnfermero: Enfermero = {
        ...this.enfermero,
        dni: enfermeroFormValue.dni,
        nombre: enfermeroFormValue.nombre,
        apellido: enfermeroFormValue.apellido,
        turno: enfermeroFormValue.turno
      };

      this.enfermeroService.updateEnfermero(this.enfermero.id, updatedEnfermero).subscribe(() => {
        Swal.fire({
          title: 'Éxito',
          text: 'Enfermero actualizado correctamente',
          icon: 'success',
          confirmButtonText: 'Aceptar'
        }).then(() => {
          this.router.navigate(['/doctores']);
        });
      });
    } else {
      this.enfermeroService.crearEnfermero(enfermeroFormValue).subscribe(() => {
        Swal.fire({
          title: 'Éxito',
          text: 'Enfermero creado correctamente',
          icon: 'success',
          confirmButtonText: 'Aceptar'
        }).then(() => {
          this.router.navigate(['/doctores']);
        });
      });
    }
  }
}
