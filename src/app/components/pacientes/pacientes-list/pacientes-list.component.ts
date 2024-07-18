import { Component, inject} from '@angular/core';
import { RouterModule } from '@angular/router';
import { PacienteService } from '../../../services/paciente.service';
import { Paciente } from '../../../models/paciente';
@Component({
  selector: 'app-pacientes-list',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './pacientes-list.component.html',
  styleUrl: './pacientes-list.component.css'
})
export default class PacientesListComponent {
 private pacienteService = inject(PacienteService);

 pacientes : Paciente [] = [];

ngOnInit(): void {
  this.mostrarPacientes();
}

mostrarPacientes(){
  this.pacienteService.listPacientes().subscribe((pacientes) => {
    this.pacientes = pacientes;
  })
}

deletePaciente(paciente: Paciente){
  this.pacienteService.deletePacientes(paciente.id).subscribe(() => {
    this.mostrarPacientes();
  })
}

}
