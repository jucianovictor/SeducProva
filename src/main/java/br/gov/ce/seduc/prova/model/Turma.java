package br.gov.ce.seduc.prova.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.gov.ce.seduc.prova.model.enumeration.Turno;
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
@Table(name = "turma")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonInclude(Include.NON_NULL)
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "turma_id")
	private Long id;

	@Column(length = 100, nullable = false)
	private String nome;

	@Enumerated(EnumType.ORDINAL)
	@Column(length = 5, nullable = false)
	private Turno turno;
	
	@OneToMany(mappedBy = "turma")
	private Set<Disciplina> disciplinas = new HashSet<>();
	
	@ManyToMany(mappedBy = "turmas", cascade = CascadeType.REMOVE)
	private Set<Aluno> alunos = new HashSet<>();
}
