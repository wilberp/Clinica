package com.santander.clinica.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.*;


@Entity
public class Paciente extends Pessoa{

private String prontuario;
@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
private List<Endereco> enderecos = new ArrayList<>();

public String getProntuario() {
	return prontuario;
}

public void setProntuario(String prontuario) {
	this.prontuario = prontuario;
}
public void setEnderecos(Collection<Endereco> enderecos) {
	enderecos.forEach(e -> adicionaEndereco(e));
}

public void adicionaEndereco(Endereco endereco) {
	endereco.setPaciente(this);
	this.enderecos.add(endereco);
}

public List<Endereco> getEnderecos() {
	return Collections.unmodifiableList(enderecos);
}
}
