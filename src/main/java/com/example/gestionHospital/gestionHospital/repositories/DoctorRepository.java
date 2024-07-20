package com.example.gestionHospital.gestionHospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestionHospital.gestionHospital.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
    
}
