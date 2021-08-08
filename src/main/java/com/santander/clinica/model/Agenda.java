package com.santander.clinica.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Agenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate data;
	private String hora;
	private String situacao;
	@ManyToOne
	private Medico medico;

	@ManyToOne
	private Paciente paciente;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}

	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	public String getHora() {return hora;}

	public void setHora(String hora) {		this.hora = hora;	}

	public String getSituacao() {		return situacao;	}

	public void setSituacao(String situacao) {		this.situacao = situacao;	}

	public Paciente getPaciente() {		return paciente;	}

	public void setPaciente(Paciente paciente) {		this.paciente = paciente;	}
}
