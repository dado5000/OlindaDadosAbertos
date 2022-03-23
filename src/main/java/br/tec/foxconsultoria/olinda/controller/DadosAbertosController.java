package br.tec.foxconsultoria.olinda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.tec.foxconsultoria.olinda.domain.dto.ResponseInstituicoesDadosAbertos;
import br.tec.foxconsultoria.olinda.domain.service.DadosAbertosService;

@RestController
@RequestMapping(value = "/dados-abertos")
public class DadosAbertosController {
	
	@Autowired
	private DadosAbertosService service;
	
	@GetMapping("/agentes")
	public void consultaAgentesDadosAbertos() {
		service.consultaAgentesDadosAbertos();
	}
	
	@GetMapping("/instituicoes")
	public ResponseInstituicoesDadosAbertos consultaInstituicoesDadosAbertos() {
		return service.consultaInstituicoesDadosAbertos();
	}

}
