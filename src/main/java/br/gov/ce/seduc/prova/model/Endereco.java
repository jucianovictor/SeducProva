package br.gov.ce.seduc.prova.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
	@Column(length = 100, nullable = false)
	private String rua;

	@Column(length = 10, nullable = false)
	private String numCasa;

	@Column(length = 100, nullable = false)
	private String bairro;

	@Column(length = 100, nullable = false)
	private String cidade;

	@Column(length = 60, nullable = false)
	private String estado;
}