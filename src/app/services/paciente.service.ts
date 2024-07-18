import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Paciente } from '../models/paciente';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {

  constructor(private http: HttpClient) { }

  listPacientes(){
    return this.http.get<Paciente[]>(`http://localhost:8080/api/pacientes`);
  }

  getPacientes(id:number){
    return this.http.get<Paciente>(`http://localhost:8080/api/pacientes/${id}`);
  }

  crearPacientes(paciente:any){
    return this.http.post<Paciente>(`http://localhost:8080/api/pacientes`, paciente);
  }

  updatePacientes(id:number, paciente:any){
    return this.http.put<Paciente>(`http://localhost:8080/api/pacientes/${id}`, paciente);
  }

  deletePacientes(id:number){
    return this.http.delete<void>(`http://localhost:8080/api/pacientes/${id}`);
  }
}
