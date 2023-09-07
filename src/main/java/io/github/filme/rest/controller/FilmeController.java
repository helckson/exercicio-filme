package io.github.filme.rest.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.filme.domain.entity.Filme;
import io.github.filme.rest.dto.FilmeDTO;
import io.github.filme.service.impl.FilmeServiceImpl;

@RestController
@RequestMapping("/api/filme")
public class FilmeController {

	@Autowired
	FilmeServiceImpl service;
	
	@GetMapping
	public List<FilmeDTO> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public FilmeDTO findById(@PathVariable UUID id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Filme create(@RequestBody FilmeDTO dto) {
		return service.create(dto);
	}
}
