package br.tec.foxconsultoria.olinda.domain.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseInstituicoesDadosAbertos implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	@JsonProperty("value") 
	private List<InstituicaoDadosAbertos> instituicoesDadosAbertos;
	
	

	public List<InstituicaoDadosAbertos> getInstituicoesDadosAbertos() {
		return instituicoesDadosAbertos;
	}

	public void setInstituicoesDadosAbertos(List<InstituicaoDadosAbertos> instituicoesDadosAbertos) {
		this.instituicoesDadosAbertos = instituicoesDadosAbertos;
	} 
	

}
