package com.santander.clinica.model;

import javax.persistence.*;

@Entity
public class Medico extends Pessoa{

	private String crm;
	private String especialidade;

//	@ManyToMany
//	@JoinColumn(name = "agenda_fk")
//	private Agenda agenda;


	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

//

}
