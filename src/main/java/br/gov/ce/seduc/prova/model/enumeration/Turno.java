package br.gov.ce.seduc.prova.model.enumeration;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Turno {
	@JsonProperty("M")
	MANHA("M"),
	
	@JsonProperty("T")
	TARDE("T");

	private String turno;
}
	
