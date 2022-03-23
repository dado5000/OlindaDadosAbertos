package br.tec.foxconsultoria.olinda.domain.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseAgentesDadosAbertos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("registros") 
	private List<ResponseAgenteDadosAbertos> agentesDadosAbertos;  

	@JsonProperty("meta") 
	private TransmissoraDadosAbertos transmissoraDadosAbertos; 

	@JsonProperty("links") 
	private TransmissoraLinks transmissoraLinks;

	public List<ResponseAgenteDadosAbertos> getAgentesDadosAbertos() {
		return agentesDadosAbertos;
	}

	public void setAgentesDadosAbertos(List<ResponseAgenteDadosAbertos> agentesDadosAbertos) {
		this.agentesDadosAbertos = agentesDadosAbertos;
	}

	public TransmissoraDadosAbertos getTransmissoraDadosAbertos() {
		return transmissoraDadosAbertos;
	}

	public void setTransmissoraDadosAbertos(TransmissoraDadosAbertos transmissoraDadosAbertos) {
		this.transmissoraDadosAbertos = transmissoraDadosAbertos;
	}

	public TransmissoraLinks getTransmissoraLinks() {
		return transmissoraLinks;
	}

	public void setTransmissoraLinks(TransmissoraLinks transmissoraLinks) {
		this.transmissoraLinks = transmissoraLinks;
	} 

}
