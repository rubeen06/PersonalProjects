import { Component, inject, OnInit } from '@angular/core';
import { DoctorService } from '../../../services/doctor.service';
import { RouterModule } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-doctores-detail',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './doctores-detail.component.html',
  styleUrl: './doctores-detail.component.css'
})
export default class DoctoresDetailComponent implements OnInit{
  private doctorService = inject(DoctorService);
  private route = inject(ActivatedRoute);

  doctor: any = {};

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if(id){
      this.doctorService.getDoctor(parseInt(id)).subscribe((doctor: any) => {
        this.doctor = doctor;
      })
    } 
  }
}
