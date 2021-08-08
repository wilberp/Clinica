package com.santander.clinica.dto;

import com.santander.clinica.model.Endereco;
import com.santander.clinica.model.Paciente;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PacienteDto extends RepresentationModel<PacienteDto> {

	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private String prontuario;
	private List<Endereco> enderecos = new ArrayList<>();
	
	public PacienteDto(String nome, String cpf, LocalDate dataNascimento, String prontuario, List<Endereco> enderecos) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.prontuario = prontuario;
		this.enderecos = enderecos;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getProntuario() {
		return prontuario;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public static PacienteDto converte(Paciente paciente) {
		return new PacienteDto(paciente.getNome(), paciente.getCpf(), paciente.getDataNascimento(), paciente.getProntuario(), paciente.getEnderecos());
	}
	
}
