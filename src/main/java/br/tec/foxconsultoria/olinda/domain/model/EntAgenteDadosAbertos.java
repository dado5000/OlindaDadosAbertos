package br.tec.foxconsultoria.olinda.domain.model;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "AGENTES_DADOS_ABERTOS")
public class EntAgenteDadosAbertos implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@Column(name = "CPF_CNPJ_AGENTE", length = 14)
	private String cpfCnpjAgente; 

	@Column(name = "NOME_AGENTE", length = 100)
	private String nomeAgente; 

	@Column(name = "NOME_INSTITUICAO", length = 100)
	private String nomeinstituicao; 

	@Column(name = "ISPB_INSTITUICAO", nullable = false, length = 8)
	private String ispbInstituicao; 

	@Column(name = "ATIVO", nullable = false)
	private boolean ativo; 

	@UpdateTimestamp
	@Column(name = "DATA_ALTERACAO", nullable = false, columnDefinition = "datetime")
	private OffsetDateTime dataAlteracao;

}
