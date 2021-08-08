package com.santander.clinica.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.santander.clinica.dto.PacienteDto;
import com.santander.clinica.model.Agenda;
import com.santander.clinica.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.santander.clinica.model.Medico;
import com.santander.clinica.model.Paciente;
import com.santander.clinica.service.PacienteService;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

	private PacienteService pacienteService;
	private AgendaService agendaService;

	@Autowired
	public PacienteController( PacienteService pacienteService,
							   AgendaService agendaService) {
		this.pacienteService = pacienteService;
		this.agendaService = agendaService;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Paciente salvar(@RequestBody Paciente clienteDto) {
	//	Paciente cliente = clienteDto.converte();
		return pacienteService.salvar(clienteDto);
	}

//	@GetMapping
//	public ResponseEntity<?> buscarTodos() {
//		Link self = linkTo(PacienteController.class).withSelfRel();
//		Link pacientess = linkTo(PacienteController.class).withRel("pacientes");
//		return 	ResponseEntity.ok(RepresentationModel.of(pacienteService.buscarTodos()).add(self).add(pacientess));
//	}


	@GetMapping
	public ResponseEntity<?> buscarTodos() {

		List<PacienteDto> paciente = pacienteService.buscarTodos().stream().map( p->{
			Link selfProduto = linkTo(PacienteController.class).slash(p.getId()).withSelfRel();
			return PacienteDto.converte(p).add(selfProduto);
		}).collect(Collectors.toList());
		return ResponseEntity.ok(paciente);
	}


	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
		Link self = linkTo(PacienteController.class).slash(id).withSelfRel();
		Link pacientess = linkTo(PacienteController.class).withRel("pacientes");
			return 	ResponseEntity.ok(RepresentationModel.of(pacienteService.buscarPorId(id)).add(self)
					.add(pacientess));
	}

	//buscar médico por especialidade
	@GetMapping("/especialidade/{especialidade}")
	public List<Medico> buscarPorEspecialidade(@PathVariable String especialidade) {
		
		return pacienteService.buscarPorEspecialidade(especialidade);
	}

	//consultar agenda do médico com as datas livres
	@GetMapping("/consulta-agenda")
	public List<Agenda> buscarAgendaMedicoPorDataHoraLivre(
			@RequestParam(name = "idmedico", required = true) Integer medico_id,
			@RequestParam(name = "data", required = true)
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataConsulta) {

		return agendaService.buscaAgendaMedicoDataLivre(medico_id, dataConsulta);
	}
	
}
