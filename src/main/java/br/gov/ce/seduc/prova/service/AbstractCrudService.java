package br.gov.ce.seduc.prova.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AbstractCrudService<DTO, T, ID> {
	Optional<T> findById(ID id);
	Page<T> findAll(Pageable pageable);
	List<T> findAll();
	T save(T t);
	Optional<T> update(ID id, T t);
	void deleteById(ID id);
	DTO convertEntityToDTO(T t);
}
