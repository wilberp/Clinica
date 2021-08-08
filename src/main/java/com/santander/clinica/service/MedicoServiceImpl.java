package com.santander.clinica.service;

import java.time.LocalDate;
import java.util.List;

import com.santander.clinica.repository.MedicoSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.clinica.model.Medico;
import com.santander.clinica.model.Paciente;
import com.santander.clinica.repository.MedicoRepository;
import com.santander.clinica.repository.PacienteRepository;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class MedicoServiceImpl implements MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Override
	public Medico salvar(Medico medico) {
		return medicoRepository.save(medico);
	}

	@Override
	public Medico buscarPorId(Integer id) {
		return medicoRepository.getOne(id);
	}

	@Override
	public List<Medico> buscarPorNomeOuEspecialidade(String nome, String especialidade) {
		return medicoRepository.findAll(where(MedicoSpecification.nomes(nome))
				.or(MedicoSpecification.especialidades(especialidade)));
	}


}
