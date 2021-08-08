package com.santander.clinica.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santander.clinica.model.Agenda;
import com.santander.clinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AgendaRepository extends JpaRepository<Agenda, Integer>, JpaSpecificationExecutor<Agenda> {

	List<Agenda> findAllByData(LocalDate data);
}
