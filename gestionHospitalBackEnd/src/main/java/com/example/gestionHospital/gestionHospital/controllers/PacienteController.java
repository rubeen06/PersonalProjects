package com.example.gestionHospital.gestionHospital.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestionHospital.gestionHospital.dtos.PacienteDTO;
import com.example.gestionHospital.gestionHospital.services.PacienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pacientes")
@Validated
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<PacienteDTO> getAllPacientes() {
        return pacienteService.mostrarPacientes();
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> createPaciente(@Valid @RequestBody PacienteDTO pacienteDTO) {
        PacienteDTO createdPaciente = pacienteService.aniadirPaciente(pacienteDTO);
        return ResponseEntity.ok(createdPaciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> updatePaciente(@PathVariable Long id, @Valid @RequestBody PacienteDTO pacienteDTO) {
        PacienteDTO updatedPaciente = pacienteService.actualizarPaciente(id, pacienteDTO);
        return ResponseEntity.ok(updatedPaciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        pacienteService.borrarPaciente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> getPacienteById(@PathVariable Long id) {
        PacienteDTO pacienteDTO = pacienteService.buscarPorId(id);
        return ResponseEntity.ok(pacienteDTO);
    }
}
