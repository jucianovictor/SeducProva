package br.gov.ce.seduc.prova.controller.v1;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.ce.seduc.prova.model.Aluno;
import br.gov.ce.seduc.prova.model.dto.AlunoDTO;
import br.gov.ce.seduc.prova.model.dto.Response;
import br.gov.ce.seduc.prova.service.IAlunoService;
import br.gov.ce.seduc.prova.util.Indirection;

@RestController
@RequestMapping("/v1/alunos")
public class AlunoController {
	IAlunoService alunoService;

	@Autowired
	public AlunoController(IAlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@GetMapping()
	public ResponseEntity<Response<List<AlunoDTO>>> findAllPageable() {
		Response<List<AlunoDTO>> response = new Response<>();

		List<AlunoDTO> alunos = this.alunoService.findAll()
									.stream()
									.map(this::hateoasResponse)
									.collect(Collectors.toList());

		response.setData(alunos);

		return new ResponseEntity<Response<List<AlunoDTO>>>(response, HttpStatus.OK);
	}

	@GetMapping(path = "/pageable")
	public ResponseEntity<Response<Page<AlunoDTO>>> findAllPageable(
			@PageableDefault(page = 1, size = Integer.MAX_VALUE, sort = { "nome" }) Pageable pageable) {
		Response<Page<AlunoDTO>> response = new Response<>();

		Page<AlunoDTO> alunos = this.alunoService.findAll(pageable).map(this::hateoasResponse);

		response.setData(alunos);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<AlunoDTO>> findById(@PathVariable("id") Long id) {
		Response<AlunoDTO> response = new Response<>();

		Indirection<HttpStatus> status = new Indirection<HttpStatus>(HttpStatus.NOT_FOUND);

		this.alunoService.findById(id).ifPresent(p -> {
			response.setData(hateoasResponse(p));
			status.setValue(HttpStatus.OK);
		});

		return new ResponseEntity<>(response, status.getValue());
	}

	@GetMapping(value = "/matricula/{matricula}")
	public ResponseEntity<Response<AlunoDTO>> findByMatricula(@PathVariable("matricula") String matricula) {
		Response<AlunoDTO> response = new Response<>();

		Indirection<HttpStatus> status = new Indirection<HttpStatus>(HttpStatus.NOT_FOUND);

		this.alunoService.findByMatricula(matricula).ifPresent(p -> {
			response.setData(hateoasResponse(p));
			status.setValue(HttpStatus.OK);
		});

		return new ResponseEntity<>(response, status.getValue());
	}

	@PostMapping
	public ResponseEntity<Response<AlunoDTO>> save(@Valid @RequestBody AlunoDTO newAlunoDTO,
			BindingResult validationResult) {
		Response<AlunoDTO> response = new Response<>();

		if (validationResult.hasErrors()) {
			validationResult.getAllErrors().forEach(error -> response.addErrorMsgToResponse(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Aluno createdAluno = this.alunoService.save(newAlunoDTO.convertDTOToEntity());

		response.setData(hateoasResponse(createdAluno));

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Response<AlunoDTO>> update(@PathVariable("id") Long id,
			@Valid @RequestBody AlunoDTO updateAlunoDTO, BindingResult validationResult) {
		Response<AlunoDTO> response = new Response<>();

		if (validationResult.hasErrors()) {
			validationResult.getAllErrors().forEach(error -> response.addErrorMsgToResponse(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Indirection<Aluno> updatedAluno = new Indirection<>(null);
		Indirection<HttpStatus> status = new Indirection<>(HttpStatus.NOT_FOUND);

		this.alunoService.update(id, updateAlunoDTO.convertDTOToEntity()).ifPresent(p -> {
			updatedAluno.setValue(p);
			status.setValue(HttpStatus.OK);
			response.setData(hateoasResponse(updatedAluno.getValue()));
		});

		return new ResponseEntity<>(response, status.getValue());
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Response<String>> deleteById(@PathVariable("id") Long id) {
		Response<String> response = new Response<>();

		Indirection<HttpStatus> status = new Indirection<>(HttpStatus.NOT_FOUND);

		this.alunoService.findById(id).ifPresent(p -> {
			status.setValue(HttpStatus.NO_CONTENT);
			this.alunoService.deleteById(id);
		});

		return new ResponseEntity<>(response, status.getValue());
	}

	private AlunoDTO hateoasResponse(Aluno aluno) {
		Link selfLink = WebMvcLinkBuilder.linkTo(AlunoController.class).slash(aluno.getId()).withSelfRel();
		return this.alunoService.convertEntityToDTO(aluno).add(selfLink);
	}
}
