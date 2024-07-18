package com.example.gestionHospital.gestionHospital.dtos;

import java.util.Set;

import com.example.gestionHospital.gestionHospital.entities.Enfermero;
import com.example.gestionHospital.gestionHospital.entities.Paciente;

import jakarta.validation.constraints.NotBlank;

public class DoctorDTO {

    private Long id;

    private String dni;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El nombre es obligatorio")
    private String apellido;

    @NotBlank(message = "La especialización es obligatoria")
    private String especialidad;

    private Set<Enfermero> enfermeros;

    private Set<Paciente> pacientes;

    // Getters y setters omitidos para brevedad

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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Set<Enfermero> getEnfermeros() {
        return enfermeros;
    }

    public void setEnfermeros(Set<Enfermero> enfermeros) {
        this.enfermeros = enfermeros;
    }

    public Set<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(Set<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}
