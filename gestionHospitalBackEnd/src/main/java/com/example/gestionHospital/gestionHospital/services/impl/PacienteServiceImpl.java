package com.example.gestionHospital.gestionHospital.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionHospital.gestionHospital.dtos.PacienteDTO;
import com.example.gestionHospital.gestionHospital.entities.Paciente;
import com.example.gestionHospital.gestionHospital.repositories.PacienteRepository;
import com.example.gestionHospital.gestionHospital.services.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PacienteDTO aniadirPaciente(PacienteDTO pacienteDTO) {

        Paciente paciente = modelMapper.map(pacienteDTO, Paciente.class);

        Paciente savedPaciente = pacienteRepository.save(paciente);

        return modelMapper.map(savedPaciente, PacienteDTO.class);
    }

    @Override
    public List<PacienteDTO> mostrarPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes.stream()
                .map(paciente -> modelMapper.map(paciente, PacienteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PacienteDTO actualizarPaciente(Long id, PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

                paciente.setDni(pacienteDTO.getDni());
                paciente.setNombre(pacienteDTO.getNombre());
                paciente.setApellido(pacienteDTO.getApellido());
                paciente.setDiagnostico(pacienteDTO.getDiagnostico());

        modelMapper.map(pacienteDTO, paciente);


        Paciente updatedPaciente = pacienteRepository.save(paciente);
        return modelMapper.map(updatedPaciente, PacienteDTO.class);
    }

    @Override
    public void borrarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public PacienteDTO buscarPorId(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        PacienteDTO pacienteDTO = modelMapper.map(paciente, PacienteDTO.class);


        // Retornar el DTO completo
        return pacienteDTO;
    }
}
