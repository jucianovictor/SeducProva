package br.gov.ce.seduc.prova.model.enumeration;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Sexo {
	@JsonProperty("M")
	MASCULINO("M"),

	@JsonProperty("F")
	FEMININO("F"),

	@JsonProperty("IDF")
	INDEFINIDO("IDF");

	private String sexo;
}
