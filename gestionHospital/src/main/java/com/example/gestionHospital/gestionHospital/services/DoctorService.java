package com.example.gestionHospital.gestionHospital.services;

import java.util.List;



import com.example.gestionHospital.gestionHospital.dtos.DoctorDTO;


public interface DoctorService {
    public DoctorDTO aniadirDoctor(DoctorDTO doctorDTO);
    public List<DoctorDTO> mostrarDoctores();
    public DoctorDTO buscarDoctorPorId(Long id);
    public DoctorDTO actualizarDoctor(Long id, DoctorDTO doctorDTO);
    public void borrarDoctor(Long id);
}