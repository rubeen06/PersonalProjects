package com.example.gestionHospital.gestionHospital.entities;

import java.util.HashSet;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dni;

    private String nombre;

    private String apellido;

    private String especialidad;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "doctor", orphanRemoval = true)
    @JsonManagedReference
    private Set<Enfermero> enfermeros= new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    @JsonManagedReference
    private Set<Paciente> pacientes= new HashSet<>();

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
    
    public void addEnfermero(Enfermero enfermero) {
        this.enfermeros.add(enfermero);
        enfermero.setDoctor(this);
    }

    public void addPaciente(Paciente paciente) {
        this.pacientes.add(paciente);
        paciente.setDoctor(this);
    }
    
    // Método para eliminar la relación con un enfermero sin eliminar la entidad enfermero
    public void removeEnfermero(Enfermero enfermero) {
        this.enfermeros.remove(enfermero);
        enfermero.setDoctor(null);
    }

    // Método para eliminar la relación con un paciente sin eliminar la entidad paciente
    public void removePaciente(Paciente paciente) {
        this.pacientes.remove(paciente);
        paciente.setDoctor(null);
    }

    
}
