package com.example.gestionHospital.gestionHospital.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionHospital.gestionHospital.dtos.DoctorDTO;
import com.example.gestionHospital.gestionHospital.entities.Doctor;
import com.example.gestionHospital.gestionHospital.entities.Enfermero;
import com.example.gestionHospital.gestionHospital.entities.Paciente;
import com.example.gestionHospital.gestionHospital.repositories.DoctorRepository;
import com.example.gestionHospital.gestionHospital.repositories.EnfermeroRepository;
import com.example.gestionHospital.gestionHospital.repositories.PacienteRepository;
import com.example.gestionHospital.gestionHospital.services.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private EnfermeroRepository enfermeroRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DoctorDTO aniadirDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = modelMapper.map(doctorDTO, Doctor.class);

        Set<Enfermero> enfermeros = new HashSet<>();
        for (Enfermero enfermeroDTO : doctorDTO.getEnfermeros()) {
            if (enfermeroDTO.getId() != null) {
                Enfermero enfermero = enfermeroRepository.findById(enfermeroDTO.getId()).orElse(null);
                if (enfermero != null) {
                    enfermero.setDoctor(doctor);
                    enfermeros.add(enfermero);
                }
            }
        }
        doctor.setEnfermeros(enfermeros);

        Set<Paciente> pacientes = new HashSet<>();
        for (Paciente pacienteDTO : doctorDTO.getPacientes()) {
            Paciente paciente = pacienteRepository.findById(pacienteDTO.getId()).orElse(null);
            if (paciente != null) {
                pacientes.add(paciente);
            }
        }
        doctor.setPacientes(pacientes);

        Doctor savedDoctor = doctorRepository.save(doctor);
        return modelMapper.map(savedDoctor, DoctorDTO.class);
    }

    @Override
    public List<DoctorDTO> mostrarDoctores() {
        return doctorRepository.findAll()
                .stream()
                .map(doctor -> modelMapper.map(doctor, DoctorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDTO actualizarDoctor(Long id, DoctorDTO doctorDTO) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));

        // Actualizar campos simples
        doctor.setDni(doctorDTO.getDni());
        doctor.setNombre(doctorDTO.getNombre());
        doctor.setApellido(doctorDTO.getApellido());
        doctor.setEspecialidad(doctorDTO.getEspecialidad());

        // Actualizar colección de enfermeros
        Set<Enfermero> nuevosEnfermeros = new HashSet<>();
        for (Enfermero enfermeroDTO : doctorDTO.getEnfermeros()) {
            if (enfermeroDTO.getId() != null) {
                Enfermero enfermero = enfermeroRepository.findById(enfermeroDTO.getId()).orElse(null);
                if (enfermero != null) {
                    enfermero.setDoctor(doctor);
                    nuevosEnfermeros.add(enfermero);
                }
            }
        }
        // Manejar eliminación de enfermeros no presentes en la nueva lista
        for (Enfermero enfermero : doctor.getEnfermeros()) {
            if (!nuevosEnfermeros.contains(enfermero)) {
                enfermero.setDoctor(null);
            }
        }
        doctor.getEnfermeros().clear(); // Limpiar la colección actual
        doctor.getEnfermeros().addAll(nuevosEnfermeros); // Añadir la nueva colección

        // Actualizar colección de pacientes
        Set<Paciente> nuevosPacientes = new HashSet<>();
        for (Paciente pacienteDTO : doctorDTO.getPacientes()) {
            if (pacienteDTO.getId() != null) {
                Paciente paciente = pacienteRepository.findById(pacienteDTO.getId()).orElse(null);
                if (paciente != null) {
                    paciente.setDoctor(doctor);
                    nuevosPacientes.add(paciente);
                }
            }
        }
        // Manejar eliminación de pacientes no presentes en la nueva lista
        for (Paciente paciente : doctor.getPacientes()) {
            if (!nuevosPacientes.contains(paciente)) {
                paciente.setDoctor(null);
            }
        }
        doctor.getPacientes().clear(); // Limpiar la colección actual
        doctor.getPacientes().addAll(nuevosPacientes); // Añadir la nueva colección

        Doctor updatedDoctor = doctorRepository.save(doctor);
        return modelMapper.map(updatedDoctor, DoctorDTO.class);
    }

    @Override
    public void borrarDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));

        // Copiar las colecciones para evitar ConcurrentModificationException
        Set<Enfermero> enfermeros = new HashSet<>(doctor.getEnfermeros());
        Set<Paciente> pacientes = new HashSet<>(doctor.getPacientes());

        // Eliminar las relaciones sin eliminar las entidades
        for (Enfermero enfermero : enfermeros) {
            doctor.removeEnfermero(enfermero);
        }

        for (Paciente paciente : pacientes) {
            doctor.removePaciente(paciente);
        }

        doctorRepository.delete(doctor);

    }

    @Override
    public DoctorDTO buscarDoctorPorId(Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
        doctor.getEnfermeros().size(); // Carga explícitamente enfermeros
        return modelMapper.map(doctor, DoctorDTO.class);
    }

}
