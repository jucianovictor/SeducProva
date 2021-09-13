package br.gov.ce.seduc.prova.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.gov.ce.seduc.prova.model.enumeration.Sexo;
import br.gov.ce.seduc.prova.model.generator.MatriculaGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aluno")
@JsonInclude(Include.NON_NULL)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aluno_id")
	private Long id;
	
	@GeneratorType(type = MatriculaGenerator.class, when = GenerationTime.INSERT)
	@Column(length = 100, nullable = false, unique = true, updatable = false)
	private String matricula;

	@Column(length = 100, nullable = false)
	private String nome;

	@Enumerated(EnumType.ORDINAL)
	@Column(length = 5, nullable = false)
	private Sexo sexo;

	@Column(nullable = false)
	private LocalDate dtNascimento;
	
	@Column(length = 100, nullable = false)
	private String cidadeNatal;

	@Embedded
    private Endereco endereco;
	
	@ManyToMany
	@JoinTable(
	  name = "aluno_turma", 
	  joinColumns = @JoinColumn(name = "aluno_id"), 
	  inverseJoinColumns = @JoinColumn(name = "turma_id")
	)
	private Set<Turma> turmas = new HashSet<>();
}
