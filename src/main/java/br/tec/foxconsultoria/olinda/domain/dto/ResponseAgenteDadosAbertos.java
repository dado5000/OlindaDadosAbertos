package br.tec.foxconsultoria.olinda.domain.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseAgenteDadosAbertos implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("cnpj_agente_saque") 
	String cpfCnpjAgente; 

	@JsonProperty("nome_agente_saque") 
	String nomeAgente;

	public String getCpfCnpjAgente() {
		return cpfCnpjAgente;
	}

	public void setCpfCnpjAgente(String cpfCnpjAgente) {
		this.cpfCnpjAgente = cpfCnpjAgente;
	}

	public String getNomeAgente() {
		return nomeAgente;
	}

	public void setNomeAgente(String nomeAgente) {
		this.nomeAgente = nomeAgente;
	}

	@Override
	public String toString() {
		return "AgenteDadosAbertos [cpfCnpjAgente=" + cpfCnpjAgente + ", nomeAgente=" + nomeAgente + "]";
	} 
	
	

}
