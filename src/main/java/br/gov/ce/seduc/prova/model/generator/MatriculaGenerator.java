package br.gov.ce.seduc.prova.model.generator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.Session;
import org.hibernate.tuple.ValueGenerator;

import br.gov.ce.seduc.prova.model.Aluno;

public class MatriculaGenerator implements ValueGenerator<String> {
    @Override
    public String generateValue(Session session, Object owner) {
        try {
			return MatriculaGenerator.buildValue(((Aluno) owner).getDtNascimento());
		} catch (Exception e) {
			e.printStackTrace();
			return MatriculaGenerator.buildValue(LocalDate.now());
		}
    }

    public static String buildValue(LocalDate dtNascimentoAluno) {
    	return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss"))
    			.concat(dtNascimentoAluno.format(DateTimeFormatter.BASIC_ISO_DATE));
    }
}
