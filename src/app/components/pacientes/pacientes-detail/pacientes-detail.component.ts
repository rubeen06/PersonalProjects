import { Component, inject, OnInit } from '@angular/core';
import { PacienteService } from '../../../services/paciente.service';
import { Router, RouterModule } from '@angular/router';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-pacientes-detail',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './pacientes-detail.component.html',
  styleUrl: './pacientes-detail.component.css'
})
export default class PacientesDetailComponent implements OnInit {
  private route = inject(ActivatedRoute);
  private pacienteService = inject(PacienteService);

  paciente: any= {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if(id){
      this.pacienteService.getPacientes(parseInt(id)).subscribe((paciente: any) => {
        this.paciente = paciente;
      })
    } 
  }
}
