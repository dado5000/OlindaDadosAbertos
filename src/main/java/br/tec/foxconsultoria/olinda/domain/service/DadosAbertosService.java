package br.tec.foxconsultoria.olinda.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.tec.foxconsultoria.olinda.domain.dto.InstituicaoDadosAbertos;
import br.tec.foxconsultoria.olinda.domain.dto.ResponseAgentesDadosAbertos;
import br.tec.foxconsultoria.olinda.domain.dto.ResponseInstituicoesDadosAbertos;
import br.tec.foxconsultoria.olinda.domain.model.EntAgenteDadosAbertos;
import br.tec.foxconsultoria.olinda.domain.repository.DadosAbertosClientImpl;
import br.tec.foxconsultoria.olinda.domain.repository.DadosAbertosRepository;

@Service
public class DadosAbertosService {

	private static final Logger log = LoggerFactory.getLogger(DadosAbertosService.class);

	/* Lista de agentes parceiros fornecida pelas intituições */
	List<EntAgenteDadosAbertos> agentesDadosAbertos = new ArrayList<>();	

	@Autowired
	private DadosAbertosClientImpl dadosAbertos;
	
	@Autowired
	private DadosAbertosRepository repository;

	public void consultaAgentesDadosAbertos() {

		/* Consulta Instituições de dados abertos em PRODUÇÃO */
		ResponseInstituicoesDadosAbertos intituicoesDadosAbertos = consultaInstituicoesDadosAbertos();

		for (InstituicaoDadosAbertos instituicaoDadosAbertos : intituicoesDadosAbertos.getInstituicoesDadosAbertos()) {

			String urlDados = instituicaoDadosAbertos.getUrlDados();
			
			do {
				
				ResponseAgentesDadosAbertos responseAgenteDadosAbertos = null;
				
				try {
					responseAgenteDadosAbertos = dadosAbertos.consultaAgentes(urlDados);
					log.info("URL Atual: {}", urlDados);
					
					montaAgente(responseAgenteDadosAbertos);				
					urlDados = responseAgenteDadosAbertos.getTransmissoraLinks().getNext();
				} catch (Exception e) {
					log.error(e.getMessage());
					break;
				}
				
			} while (StringUtils.hasText(urlDados));		

		}
			
		agentesDadosAbertos.clear();
	}

	private void montaAgente(ResponseAgentesDadosAbertos responseAgentesDadosAbertos) {
		
		if (responseAgentesDadosAbertos != null) {

			for (var agenteSaqueDadosAbertos : responseAgentesDadosAbertos.getAgentesDadosAbertos()) {
				
				var agente = new EntAgenteDadosAbertos();

				agente.setCpfCnpjAgente(agenteSaqueDadosAbertos.getCpfCnpjAgente());
				agente.setNomeAgente(agenteSaqueDadosAbertos.getNomeAgente());
				agente.setIspbInstituicao(
						responseAgentesDadosAbertos.getTransmissoraDadosAbertos().getIspbTransmissora());
				agente.setNomeinstituicao(
						responseAgentesDadosAbertos.getTransmissoraDadosAbertos().getNomeTransmissora());
				agente.setAtivo(true);

				agentesDadosAbertos.add(agente);
			}
			
			
			  if(!agentesDadosAbertos.isEmpty()) {
				  log.info("Total de agentes encontrados: {}", agentesDadosAbertos.size());
			  }			 
			
			repository.saveAll(agentesDadosAbertos);

		}		
		
	}

	public ResponseInstituicoesDadosAbertos consultaInstituicoesDadosAbertos() {
		return dadosAbertos.getInstituicoes();
	}

}
