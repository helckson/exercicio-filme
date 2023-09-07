package io.github.filme.rest.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.filme.domain.entity.Usuario;
import io.github.filme.rest.dto.UsuarioDTO;
import io.github.filme.rest.dto.UsuarioDTO2;
import io.github.filme.service.TokenService;
import io.github.filme.service.impl.UsuarioServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	UsuarioServiceImpl service;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	TokenService tokenService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Usuario create(@RequestBody Usuario usuario) {
		return service.create(usuario);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid UsuarioDTO2 data) {
		return service.login(data);
	}
	
	@GetMapping("/{id}")
	public UsuarioDTO findById(@PathVariable UUID id) {
		return service.findId(id);
	}
	
	@PostMapping("/{usuarioId}/role/{roleId}")
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@PathVariable UUID usuarioId,
					@PathVariable UUID roleId) {
		service.salvarMuitos(usuarioId, roleId);
	}
}
