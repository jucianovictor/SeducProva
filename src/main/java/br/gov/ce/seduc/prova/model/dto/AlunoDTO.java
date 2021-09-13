package br.gov.ce.seduc.prova.model.dto;


import java.time.LocalDate;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonInclude;

import br.gov.ce.seduc.prova.model.Aluno;
import br.gov.ce.seduc.prova.model.Endereco;
import br.gov.ce.seduc.prova.model.Turma;
import br.gov.ce.seduc.prova.model.enumeration.Sexo;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlunoDTO extends RepresentationModel<AlunoDTO> {
	private Long id;

	private String matricula;

	@NotNull(message="nome não pode estar nulo")
	private String nome;

	@NotNull(message="cidadeNatal não pode estar nulo")
	private String cidadeNatal;

	@NotNull(message="endereco não pode estar nulo")
	@Valid
    private Endereco endereco;
	
	@NotNull(message="dtNascimento não pode estar nulo")
	private LocalDate dtNascimento;

	@NotNull(message="sexo não pode estar nulo")
	private Sexo sexo;

	@NotNull(message="turmas não pode estar nulo")
    private Set<Turma> turmas;

	public Aluno convertDTOToEntity() {
		return new ModelMapper().map(this, Aluno.class);
	}
}
