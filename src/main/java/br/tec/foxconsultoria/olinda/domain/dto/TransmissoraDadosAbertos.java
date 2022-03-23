package br.tec.foxconsultoria.olinda.domain.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransmissoraDadosAbertos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("nome_transmissora") 
	private String nomeTransmissora; 

	@JsonProperty("ispb_transmissora") 
	private String ispbTransmissora;

	public String getNomeTransmissora() {
		return nomeTransmissora;
	}

	public void setNomeTransmissora(String nomeTransmissora) {
		this.nomeTransmissora = nomeTransmissora;
	}

	public String getIspbTransmissora() {
		return ispbTransmissora;
	}

	public void setIspbTransmissora(String ispbTransmissora) {
		this.ispbTransmissora = ispbTransmissora;
	}

	@Override
	public String toString() {
		return "TransmissoraDadosAbertos [nomeTransmissora=" + nomeTransmissora + ", ispbTransmissora="
				+ ispbTransmissora + "]";
	} 
	

}
