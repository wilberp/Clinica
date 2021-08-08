package com.santander.clinica.service;

import java.time.LocalDate;
import java.util.List;

import com.santander.clinica.repository.AgendaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.clinica.model.Agenda;
import com.santander.clinica.repository.AgendaRepository;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class AgendaServiceImpl implements AgendaService {

	
	@Autowired
	private AgendaRepository agendaRepository;
	
	@Override
	public List<Agenda> buscaPacienteDataConsulta(LocalDate data) {
		return agendaRepository.findAllByData(data);
	}

	@Override
	public List<Agenda> buscaAgendaMedicoDataLivre(Integer medico_id, LocalDate data) {
		return agendaRepository.findAll(
				where(AgendaSpecification.medicos(medico_id))
						.and(AgendaSpecification.dataHoraLivre(data))
						.and(AgendaSpecification.situacaoHorario()));
	}

}
