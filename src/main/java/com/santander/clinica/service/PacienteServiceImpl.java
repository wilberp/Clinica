package com.santander.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.clinica.model.Medico;
import com.santander.clinica.model.Paciente;
import com.santander.clinica.repository.MedicoRepository;
import com.santander.clinica.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService{

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Override
	public Paciente salvar(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}

	@Override
	public List<Paciente> buscarTodos() {
		return pacienteRepository.findAll();
	}

	@Override
	public Paciente buscarPorId(Integer id) {
		return pacienteRepository.getOne(id);
	}

	@Override
	public List<Medico> buscarPorEspecialidade(String especialidade) {
		return medicoRepository.findAllByEspecialidade(especialidade);
	}


}
