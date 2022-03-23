package br.tec.foxconsultoria.olinda.domain.repository;

import java.util.function.Supplier;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.tec.foxconsultoria.olinda.domain.dto.ResponseAgentesDadosAbertos;
import br.tec.foxconsultoria.olinda.domain.dto.ResponseInstituicoesDadosAbertos;

@Component
public class DadosAbertosClientImpl implements DadosAbertosClient {
	
	private final String olindaResourceUrl;
	
	public DadosAbertosClientImpl() {		
		this.olindaResourceUrl = "https://olinda.bcb.gov.br/olinda/servico/DASFN/versao/v1/odata/Recursos?"
				+ "$filter=Api eq 'pix_saque' and Situacao eq 'Produção'&$format=json";
	}

	@Override
	public ResponseInstituicoesDadosAbertos getInstituicoes() {

		try {
			return restTemplate().get().getForObject(olindaResourceUrl, ResponseInstituicoesDadosAbertos.class);
		} catch (Exception e) {
			throw new RestClientException(e.getMessage());
		}
	}

	@Override
	public ResponseAgentesDadosAbertos consultaAgentes(String url) {		
		try {
			return restTemplate().get().getForObject(url, ResponseAgentesDadosAbertos.class);
		} catch (Exception e) {
			throw new RestClientException(e.getMessage());
		}
	}
	
	private Supplier<RestTemplate> restTemplate() {
		return () -> {
			return new RestTemplateBuilder()
					.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.build();
		};
	}

}
