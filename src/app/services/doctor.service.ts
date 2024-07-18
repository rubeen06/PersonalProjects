import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Doctor } from '../models/doctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private http: HttpClient) { }

  listDoctores(){
    return this.http.get<Doctor[]>(`http://localhost:8080/api/doctores`);
  }

  getDoctor(id:number){
    return this.http.get<Doctor>(`http://localhost:8080/api/doctores/${id}`);
  }

  crearDoctor(doctor: Doctor){
    return this.http.post<Doctor>(`http://localhost:8080/api/doctores`, doctor);
  }

  updateDoctor(id:number, doctor:Doctor){
    return this.http.put<Doctor>(`http://localhost:8080/api/doctores/${id}`, doctor);
  }

  deleteDoctor(id:number){
    return this.http.delete<void>(`http://localhost:8080/api/doctores/${id}`);
  }
}
