package br.gov.ce.seduc.prova.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.ce.seduc.prova.model.Aluno;
import br.gov.ce.seduc.prova.model.dto.AlunoDTO;
import br.gov.ce.seduc.prova.repository.IAlunoRepository;
import br.gov.ce.seduc.prova.service.IAlunoService;
import br.gov.ce.seduc.prova.util.Indirection;

@Service
public class AlunoServiceImpl implements IAlunoService {

	@Autowired
	IAlunoRepository alunoRepository;

	@Override
	public Optional<Aluno> findById(Long id) {
		return this.alunoRepository.findById(id);
	}

	@Override
	public Optional<Aluno> findByMatricula(String matricula) {
		return this.alunoRepository.findByMatricula(matricula);
	}

	@Override
	public Page<Aluno> findAll(Pageable pageable) {
		return this.alunoRepository.findAll(pageable);
	}

	@Override
	public List<Aluno> findAll() {
		return StreamSupport
				  .stream(this.alunoRepository.findAll().spliterator(), false)
				  .collect(Collectors.toList());
	}

	@Transactional
	@Override
	public Aluno save(Aluno aluno) {
		return this.alunoRepository.save(aluno);
	}

	@Transactional
	@Override
	public Optional<Aluno> update(Long id, Aluno aluno) {
		Indirection<Optional<Aluno>> alunoIndirection = new Indirection<Optional<Aluno>>(Optional.ofNullable(null));

		aluno.setId(id);

		this.findById(id)
			.ifPresent(_unused -> 
				alunoIndirection.setValue(Optional.ofNullable(this.alunoRepository.save(aluno)))
			);
		return alunoIndirection.getValue();
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		this.alunoRepository.deleteById(id);
	}

	@Override
	public AlunoDTO convertEntityToDTO(Aluno aluno) {
		return new ModelMapper().map(aluno, AlunoDTO.class);
	}
}
