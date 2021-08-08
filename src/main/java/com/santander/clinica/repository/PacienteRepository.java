package com.santander.clinica.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santander.clinica.model.Paciente;


public interface PacienteRepository extends JpaRepository<Paciente, Integer> { 

}
