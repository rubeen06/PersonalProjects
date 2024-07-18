package com.example.gestionHospital.gestionHospital.services;

import java.util.List;

import com.example.gestionHospital.gestionHospital.dtos.PacienteDTO;

public interface PacienteService {
    public PacienteDTO aniadirPaciente(PacienteDTO pacienteDTO);
    public List<PacienteDTO> mostrarPacientes();
    public PacienteDTO actualizarPaciente(Long id, PacienteDTO pacienteDTO);
    public void borrarPaciente(Long id);
    public PacienteDTO buscarPorId(Long id);
}
