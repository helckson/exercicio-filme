package io.github.filme.service;

import java.util.List;
import java.util.UUID;

import io.github.filme.domain.entity.Filme;
import io.github.filme.rest.dto.FilmeDTO;

public interface FilmeService {

	Filme create(FilmeDTO dto);
	
	FilmeDTO findById(UUID id);
	
	List<FilmeDTO> findAll();
}
