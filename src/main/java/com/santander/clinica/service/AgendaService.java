package com.santander.clinica.service;

import java.time.LocalDate;
import java.util.List;

import com.santander.clinica.model.Agenda;

public interface AgendaService {
	List<Agenda> buscaPacienteDataConsulta(LocalDate data);

	//  consultar agenda do médico com as datas livres
	List<Agenda> buscaAgendaMedicoDataLivre(Integer medico_id, LocalDate data);
}
