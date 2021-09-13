package br.gov.ce.seduc.prova.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Indirection<T> {
	private T value;
}
