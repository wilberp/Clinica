package com.santander.clinica.service;

import java.util.List;

import com.santander.clinica.model.Medico;
import com.santander.clinica.model.Paciente;

public interface PacienteService {
	Paciente salvar(Paciente paciente);
	List<Paciente> buscarTodos();
	Paciente buscarPorId(Integer id);
	List<Medico> buscarPorEspecialidade(String especialidade); 

	
}
