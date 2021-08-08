package com.santander.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santander.clinica.model.Medico;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface MedicoRepository extends JpaRepository<Medico, Integer>, JpaSpecificationExecutor<Medico> {
	
	
	List<Medico> findAllByEspecialidade(String especialidade);

}
