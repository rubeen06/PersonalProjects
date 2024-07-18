import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Enfermero } from '../models/enfermero';

@Injectable({
  providedIn: 'root'
})
export class EnfermeroService {

  constructor(private http: HttpClient) { }

  listEnfermeros(){
    return this.http.get<Enfermero[]>(`http://localhost:8080/api/enfermeros`);
  }

  getEnfermero(id:number){
    return this.http.get<Enfermero>(`http://localhost:8080/api/enfermeros/${id}`);
  }

  crearEnfermero(enfermero:any){
    return this.http.post<Enfermero>(`http://localhost:8080/api/enfermeros`, enfermero);
  }

  updateEnfermero(id:number, enfermero:any){
    return this.http.put<Enfermero>(`http://localhost:8080/api/enfermeros/${id}`, enfermero);
  }

  deleteEnfermero(id:number){
    return this.http.delete<void>(`http://localhost:8080/api/enfermeros/${id}`);
  }
}
