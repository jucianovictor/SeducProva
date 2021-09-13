package br.gov.ce.seduc.prova.questoes.sete;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class Main {
	@Test
	public void test() {
		List<String> listaX = Arrays.asList("c","c","b","a");
		List<String> listaY = Arrays.asList("b", "b", "a", "a","c");
		
		List<String> mergedLists = this.mergeListsToAlphabeticOrderAndDistinct(listaX, listaY);

		mergedLists.forEach(System.out::println);

		assertEquals(mergedLists, Arrays.asList("a", "b", "c"));
	}
	
	private List<String> mergeListsToAlphabeticOrderAndDistinct(List<String> listaX, List<String> listaY) {
		 return Stream.concat(listaX.stream(), listaY.stream())
					.distinct()
					.sorted((x, y) -> x.compareTo(y))
					.collect(Collectors.toList());
	}
}
