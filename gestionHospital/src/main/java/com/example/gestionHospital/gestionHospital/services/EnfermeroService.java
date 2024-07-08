package com.example.gestionHospital.gestionHospital.services;

import java.util.List;

import com.example.gestionHospital.gestionHospital.dtos.EnfermeroDTO;

public interface EnfermeroService {
    public EnfermeroDTO aniadirEnfermero(EnfermeroDTO enfermeroDTO);
    public List<EnfermeroDTO> mostrarEnfermeros();
    public EnfermeroDTO actualizarEnfermero(Long id, EnfermeroDTO enfermeroDTO);
    public void borrarEnfermero(Long id);
    public EnfermeroDTO buscarEnfermeroPorId(Long id);
}
