package br.gov.ce.seduc.prova.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.gov.ce.seduc.prova.model.Aluno;

@Repository
public interface IAlunoRepository extends PagingAndSortingRepository<Aluno, Long> {
	
	@Query(value = "SELECT a FROM Aluno a WHERE a.matricula = ?1")
	Optional<Aluno> findByMatricula(String matricula);
}
