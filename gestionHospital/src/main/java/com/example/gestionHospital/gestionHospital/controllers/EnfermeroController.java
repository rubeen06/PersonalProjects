package com.example.gestionHospital.gestionHospital.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.gestionHospital.gestionHospital.dtos.EnfermeroDTO;
import com.example.gestionHospital.gestionHospital.services.EnfermeroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/enfermeros")
@Validated
public class EnfermeroController {

    @Autowired
    private EnfermeroService enfermeroService;

    @GetMapping
    public List<EnfermeroDTO> getAllEnfermeros() {
        return enfermeroService.mostrarEnfermeros();
    }

    @PostMapping
    public ResponseEntity<EnfermeroDTO> createEnfermero(@Valid @RequestBody EnfermeroDTO enfermeroDTO) {
        EnfermeroDTO createdEnfermero = enfermeroService.aniadirEnfermero(enfermeroDTO);
        return ResponseEntity.ok(createdEnfermero);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnfermeroDTO> updateEnfermero(@PathVariable Long id, @Valid @RequestBody EnfermeroDTO enfermeroDTO) {
        EnfermeroDTO updatedEnfermero = enfermeroService.actualizarEnfermero(id, enfermeroDTO);
        return ResponseEntity.ok(updatedEnfermero);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnfermero(@PathVariable Long id) {
        enfermeroService.borrarEnfermero(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnfermeroDTO> getEnfermeroById(@PathVariable Long id) {
        EnfermeroDTO enfermeroDTO = enfermeroService.buscarEnfermeroPorId(id);
        return ResponseEntity.ok(enfermeroDTO);
    }
}

