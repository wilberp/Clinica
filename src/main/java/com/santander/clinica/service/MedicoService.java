package com.santander.clinica.service;

import com.santander.clinica.model.Medico;

import java.util.List;

public interface MedicoService {
	Medico salvar(Medico medico);
	Medico buscarPorId(Integer id);
	List<Medico> buscarPorNomeOuEspecialidade(String nome, String especialidade);

}
