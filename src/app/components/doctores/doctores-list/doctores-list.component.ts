import { Component, OnInit, inject } from '@angular/core';
import { DoctorService } from '../../../services/doctor.service';
import { RouterModule } from '@angular/router';
import { Doctor } from '../../../models/doctor';

@Component({
  selector: 'app-doctores-list',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './doctores-list.component.html',
  styleUrl: './doctores-list.component.css'
})
export default class DoctoresListComponent {
  private doctorService = inject(DoctorService);

  doctores: Doctor[] = [];

  ngOnInit(): void {
    this.mostrarDoctores();
  }

  mostrarDoctores(){
    this.doctorService.listDoctores().subscribe((doctores) => {
      this.doctores = doctores;
    })
  }

  deleteDoctor(doctor: Doctor){
    this.doctorService.deleteDoctor(doctor.id).subscribe(() => {
      this.mostrarDoctores();
    })
  }

}
