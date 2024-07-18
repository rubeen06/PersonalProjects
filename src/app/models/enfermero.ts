import { Doctor } from "./doctor";
import { Paciente } from "./paciente";

export class Enfermero {
  id: number;
  dni: string;
  nombre: string;
  apellido: string;
  turno: string;
  doctor: Doctor;
  

  constructor(data?: any) {
    this.id = data?.id || 0;
    this.dni = data?.dni || '';
    this.nombre = data?.nombre || '';
    this.apellido = data?.apellido || '';
    this.turno = data?.turno || '';
    this.doctor = new Doctor(data.doctor);
  }
}
