package com.santander.clinica.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.santander.clinica.model.Agenda;
import com.santander.clinica.model.Medico;
import com.santander.clinica.model.Paciente;
import com.santander.clinica.service.AgendaService;
import com.santander.clinica.service.MedicoService;

@RestController
@RequestMapping("medicos")
public class MedicoController {
	
	private MedicoService medicoService;
	private AgendaService agendaService;

	@Autowired
	public MedicoController( MedicoService medicoService, AgendaService agendaService) {
		this.medicoService = medicoService;
		this.agendaService = agendaService;
	}

    //médico vai se cadastrar
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Medico salvar(@RequestBody Medico medico) {
		return medicoService.salvar(medico);
	}
	
	@GetMapping("/{id}")
	public Medico buscarPorId(@PathVariable Integer id) {
		
		return medicoService.buscarPorId(id);
	}

	//consultar pacientes por data consulta
	@GetMapping("/consulta")
	public List<Agenda> buscarPacienteData(
			@RequestParam (name = "dataConsulta", defaultValue = "2021-07-29")
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate  dataConsulta) {

		return agendaService.buscaPacienteDataConsulta(dataConsulta);
	}

	@GetMapping("/buscar")
	public List<Medico> buscarMedicoPorNomeOuEspecialidade(
			@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "especialidade", required = false) String especialidade) {

		return medicoService.buscarPorNomeOuEspecialidade(nome, especialidade);
	}
}
