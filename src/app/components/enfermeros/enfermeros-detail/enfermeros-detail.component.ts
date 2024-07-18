import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EnfermeroService } from '../../../services/enfermero.service';

@Component({
  selector: 'app-enfermeros-detail',
  standalone: true,
  imports: [],
  templateUrl: './enfermeros-detail.component.html',
  styleUrl: './enfermeros-detail.component.css'
})
export default class EnfermerosDetailComponent implements OnInit{

  private enfermeroService = inject(EnfermeroService);
  private route = inject(ActivatedRoute);

  enfermero: any = {};

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if(id){
      this.enfermeroService.getEnfermero(parseInt(id)).subscribe((enfermero: any) => {
        this.enfermero = enfermero;
      })
    } 
  }

}
