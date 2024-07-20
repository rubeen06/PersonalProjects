package com.example.gestionHospital.gestionHospital.dtos;


import com.example.gestionHospital.gestionHospital.entities.Doctor;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PacienteDTO {
    private Long id;

    @NotNull(message = "DNI es obligatorio")
    @Size(min = 9, max = 9, message = "DNI debe tener 9 caracteres")
    private String dni;

    @NotNull(message = "Nombre es obligatorio")
    @Size(min = 2, message = "Nombre debe tener al menos 2 caracteres")
    private String nombre;

    @NotNull(message = "Apellido es obligatorio")
    @Size(min = 2, message = "Apellido debe tener al menos 2 caracteres")
    private String apellido;

    @NotNull(message = "Diagnóstico es obligatorio")
    private String diagnostico;

    private Doctor doctor;


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

}
