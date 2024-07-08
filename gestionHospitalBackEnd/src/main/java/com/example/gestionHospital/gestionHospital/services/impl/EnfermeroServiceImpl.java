package com.example.gestionHospital.gestionHospital.services.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionHospital.gestionHospital.dtos.EnfermeroDTO;
import com.example.gestionHospital.gestionHospital.entities.Enfermero;
import com.example.gestionHospital.gestionHospital.repositories.EnfermeroRepository;
import com.example.gestionHospital.gestionHospital.services.EnfermeroService;

@Service
public class EnfermeroServiceImpl implements EnfermeroService{
    @Autowired
    private EnfermeroRepository enfermeroRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EnfermeroDTO aniadirEnfermero(EnfermeroDTO enfermeroDTO) {
        Enfermero enfermero = modelMapper.map(enfermeroDTO, Enfermero.class);
        Enfermero savedEnfermero = enfermeroRepository.save(enfermero);
        return modelMapper.map(savedEnfermero, EnfermeroDTO.class);
    }

    @Override
    public List<EnfermeroDTO> mostrarEnfermeros() {
        List<Enfermero> enfermeros = enfermeroRepository.findAll();
        return enfermeros.stream()
                .map(enfermero -> modelMapper.map(enfermero, EnfermeroDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EnfermeroDTO actualizarEnfermero(Long id, EnfermeroDTO enfermeroDTO) {
        Enfermero enfermero = enfermeroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enfermero no encontrado"));
        modelMapper.map(enfermeroDTO, enfermero);
        Enfermero updatedEnfermero = enfermeroRepository.save(enfermero);
        return modelMapper.map(updatedEnfermero, EnfermeroDTO.class);
    }

    @Override
    public void borrarEnfermero(Long id) {
        enfermeroRepository.deleteById(id);
    }

    @Override
    public EnfermeroDTO buscarEnfermeroPorId(Long id) {
        Enfermero enfermero = enfermeroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enfermero no encontrado"));
        return modelMapper.map(enfermero, EnfermeroDTO.class);
    }
    
}
