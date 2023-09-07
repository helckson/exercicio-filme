package io.github.filme.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.filme.domain.entity.Filme;
import io.github.filme.domain.repository.FilmeRepository;
import io.github.filme.dto.mapper.FilmeDTOMapper;
import io.github.filme.mapper.FilmeMapper;
import io.github.filme.rest.dto.FilmeDTO;
import io.github.filme.service.FilmeService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FilmeServiceImpl implements FilmeService{

	@Autowired
	FilmeRepository repository;
	
	@Override
	public Filme create(FilmeDTO dto) {
		Filme filme = FilmeMapper.from(dto);
		Filme f = repository.save(filme);
		return f;
	}

	@Override
	public FilmeDTO findById(UUID id) {
		Filme filme = repository.findById(id).get();
		if (filme == null) {
			throw new EntityNotFoundException("Filme não encontrado");
		}
		return FilmeDTOMapper.from(filme);
	}

	@Override
	public List<FilmeDTO> findAll() {
		List<Filme> filme = repository.findAll();
		if(filme.isEmpty()) {
			throw new EntityNotFoundException("Filmes não encontrados");
		}
		else
			return FilmeDTOMapper.fromList(filme);
	}
}
