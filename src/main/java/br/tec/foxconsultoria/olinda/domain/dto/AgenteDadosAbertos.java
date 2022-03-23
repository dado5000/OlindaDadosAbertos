package br.tec.foxconsultoria.olinda.domain.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class AgenteDadosAbertos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cpfCnpjAgente; 

	private String nomeAgente; 

	private String nomeinstituicao; 

	private String ispbInstituicao; 

	private boolean ativo; 

	private OffsetDateTime dataAlteracao;

}
