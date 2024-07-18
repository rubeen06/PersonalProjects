import { Component, inject } from '@angular/core';
import { RouterModule } from '@angular/router';
import { EnfermeroService } from '../../../services/enfermero.service';
import { Enfermero } from '../../../models/enfermero';

@Component({
  selector: 'app-enfermeros-list',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './enfermeros-list.component.html',
  styleUrl: './enfermeros-list.component.css'
})
export default class EnfermerosListComponent {
  private enfermeroService = inject(EnfermeroService);

  enfermeros: Enfermero[] = [];

  ngOnInit(): void {
    this.mostrarEnfermeros();
  }

  mostrarEnfermeros(){
    this.enfermeroService.listEnfermeros().subscribe((enfermeros) => {
      this.enfermeros = enfermeros;
    })
  }

  deleteEnfermero(enfermero: Enfermero){
    this.enfermeroService.deleteEnfermero(enfermero.id).subscribe(() => {
      this.mostrarEnfermeros();
    })
  }
}
