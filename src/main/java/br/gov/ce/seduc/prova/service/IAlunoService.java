package br.gov.ce.seduc.prova.service;

import java.util.Optional;

import br.gov.ce.seduc.prova.model.Aluno;
import br.gov.ce.seduc.prova.model.dto.AlunoDTO;

public interface IAlunoService extends AbstractCrudService<AlunoDTO, Aluno, Long> {
	Optional<Aluno> findByMatricula(String matricula);
}
