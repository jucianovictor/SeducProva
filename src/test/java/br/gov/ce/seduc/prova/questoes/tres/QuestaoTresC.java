package br.gov.ce.seduc.prova.questoes.tres;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class QuestaoTresC {

	@Test
	public void comecaComAnaCaseInsensitive() {
		List<String> nomes = Arrays.asList("Ana Carla", "João Carlos", "Mário Augusto",
				"Reberto Ana Nascimento", "ana Maria", "Sophia ana");
		
		Pattern startsWithAna = Pattern.compile("^ana\s", Pattern.CASE_INSENSITIVE);
		
		//Imprimindo
		nomes.stream()
			.filter(startsWithAna.asPredicate())
			.forEach(System.out::println);
		
		//Testando
		List<String> nomeComecamComAnaInsensitive = nomes.stream()
				.filter(startsWithAna.asPredicate())
				.collect(Collectors.toList());

		assertEquals(nomeComecamComAnaInsensitive, Arrays.asList("Ana Carla", "ana Maria"));
	}
}
