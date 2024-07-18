import { Enfermero } from "./enfermero";
import { Paciente } from "./paciente";

export class Doctor {
  id: number;
  dni: string;
  nombre: string;
  apellido: string;
  especialidad: string;
  enfermeros: Enfermero[];
  pacientes: Paciente[];

  constructor(data?: any) {
    this.id = data?.id || 0;
    this.dni = data?.dni || '';
    this.nombre = data?.nombre || '';
    this.apellido = data?.apellido || '';
    this.especialidad = data?.especialidad || '';
    this.enfermeros = data?.enfermeros || [];
    this.pacientes = data?.pacientes || [];
  }
}
