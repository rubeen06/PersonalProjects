package com.example.gestionHospital.gestionHospital.services.impl;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionHospital.gestionHospital.dtos.PacienteDTO;
import com.example.gestionHospital.gestionHospital.entities.Doctor;
import com.example.gestionHospital.gestionHospital.entities.Enfermero;
import com.example.gestionHospital.gestionHospital.entities.Paciente;
import com.example.gestionHospital.gestionHospital.repositories.DoctorRepository;
import com.example.gestionHospital.gestionHospital.repositories.EnfermeroRepository;
import com.example.gestionHospital.gestionHospital.repositories.PacienteRepository;
import com.example.gestionHospital.gestionHospital.services.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService{
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private EnfermeroRepository enfermeroRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PacienteDTO aniadirPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = modelMapper.map(pacienteDTO, Paciente.class);
        Doctor doctor = doctorRepository.findById(pacienteDTO.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));
        paciente.setDoctor(doctor);

        Set<Enfermero> enfermeros = pacienteDTO.getEnfermeroIds().stream()
                .map(enfermeroId -> enfermeroRepository.findById(enfermeroId)
                        .orElseThrow(() -> new RuntimeException("Enfermero no encontrado")))
                .collect(Collectors.toSet());
        paciente.setEnfermeros(enfermeros);

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

        modelMapper.map(pacienteDTO, paciente);

        Doctor doctor = doctorRepository.findById(pacienteDTO.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));
        paciente.setDoctor(doctor);

        Set<Enfermero> enfermeros = pacienteDTO.getEnfermeroIds().stream()
                .map(enfermeroId -> enfermeroRepository.findById(enfermeroId)
                        .orElseThrow(() -> new RuntimeException("Enfermero no encontrado")))
                .collect(Collectors.toSet());
        paciente.setEnfermeros(enfermeros);

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
        return modelMapper.map(paciente, PacienteDTO.class);
    }
}
