package br.tec.foxconsultoria.olinda.domain.repository;


import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.annotation.Backoff;

import br.tec.foxconsultoria.olinda.domain.dto.ResponseAgentesDadosAbertos;
import br.tec.foxconsultoria.olinda.domain.dto.ResponseInstituicoesDadosAbertos;

public interface DadosAbertosClient {
	
	ResponseInstituicoesDadosAbertos getInstituicoes();
	
	@Retryable(maxAttempts = 3, backoff = @Backoff(delay = 1000, maxDelay = 3000, multiplier = 2))
	ResponseAgentesDadosAbertos consultaAgentes(String url);

}
