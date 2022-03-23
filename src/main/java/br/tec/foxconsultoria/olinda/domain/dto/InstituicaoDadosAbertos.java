package br.tec.foxconsultoria.olinda.domain.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InstituicaoDadosAbertos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("NomeInstituicao") 
	String nomeInstituicao; 

	@JsonProperty("URLDados") 
	String urlDados;

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public String getUrlDados() {
		return urlDados;
	}

	public void setUrlDados(String urlDados) {
		this.urlDados = urlDados;
	}

	@Override
	public String toString() {
		return "InstituicaoDadosAbertos [nomeInstituicao=" + nomeInstituicao + ", urlDados=" + urlDados + "]";
	}

}
