package com.example.gestionHospital.gestionHospital.dtos;

import java.util.Set;

public class PacienteDTO {
    private Long id;
    private String dni;
    private String nombre;
    private String apellido;
    private String diagnostico;
    private Long doctorId;
    private Set<Long> enfermeroIds;

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

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Set<Long> getEnfermeroIds() {
        return enfermeroIds;
    }

    public void setEnfermeroIds(Set<Long> enfermeroIds) {
        this.enfermeroIds = enfermeroIds;
    }
}
