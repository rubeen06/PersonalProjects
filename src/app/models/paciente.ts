import { Doctor } from "./doctor";
import { Enfermero } from "./enfermero";

export class Paciente {
    id: number;
  dni: string;
  nombre: string;
  apellido: string;
  diagnostico: string;

  constructor(data?: any) {
    this.id = data?.id || 0;
    this.dni = data?.dni || '';
    this.nombre = data?.nombre || '';
    this.apellido = data?.apellido || '';
    this.diagnostico = data?.diagnostico || '';
  }
}
