
import { Routes } from '@angular/router';


export const routes: Routes = [
  {
    path:'doctores',
    loadComponent: () => import('./components/doctores/doctores-list/doctores-list.component')
  },
  {
    path:'enfermeros',
    loadComponent: () => import('./components/enfermeros/enfermeros-list/enfermeros-list.component')
  },
  {
    path:'pacientes',
    loadComponent: () => import('./components/pacientes/pacientes-list/pacientes-list.component')
  },
  {
    path:'doctores/:id',
    loadComponent: () => import('./components/doctores/doctores-detail/doctores-detail.component')
  },
  {
    path:'crearDoctor',
    loadComponent: () => import('./components/doctores/doctores-form/doctores-form.component')
  },
  {
    path:'editarDoctor/:id',
    loadComponent: () => import('./components/doctores/doctores-form/doctores-form.component')
  },
  {
    path:'pacientes/:id',
    loadComponent: () => import('./components/pacientes/pacientes-detail/pacientes-detail.component')
  },
  {
    path:'crearPaciente',
    loadComponent: () => import('./components/pacientes/pacientes-form/pacientes-form.component')
  },
  {
    path:'editarPaciente/:id',
    loadComponent: () => import('./components/pacientes/pacientes-form/pacientes-form.component')
  },
  {
    path:'enfermeros/:id',
    loadComponent: () => import('./components/enfermeros/enfermeros-detail/enfermeros-detail.component')
  },
  {
    path:'crearEnfermero',
    loadComponent: () => import('./components/enfermeros/enfermeros-form/enfermeros-form.component')
  },
  {
    path:'editarEnfermero/:id',
    loadComponent: () => import('./components/enfermeros/enfermeros-form/enfermeros-form.component')
  }
];

