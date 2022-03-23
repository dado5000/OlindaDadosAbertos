package br.tec.foxconsultoria.olinda.domain.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransmissoraLinks implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("next") 
	private String next;

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	} 
	
	public boolean hasNext() {
		return next != null;
	}

}
