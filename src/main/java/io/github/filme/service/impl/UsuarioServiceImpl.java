package io.github.filme.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.filme.domain.entity.RoleModel;
import io.github.filme.domain.entity.Usuario;
import io.github.filme.domain.repository.RoleRepository;
import io.github.filme.domain.repository.UsuarioRepository;
import io.github.filme.dto.mapper.UsuarioDTOMapper;
import io.github.filme.rest.dto.LoginResponseDTO;
import io.github.filme.rest.dto.UsuarioDTO;
import io.github.filme.rest.dto.UsuarioDTO2;
import io.github.filme.service.TokenService;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioServiceImpl {

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	TokenService tokenService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	PasswordEncoder encoder;
	
	public ResponseEntity<?> login(UsuarioDTO2 dto) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(dto.username(), dto.password());
		var auth = authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generateToken((Usuario) auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));

	}
	
	public Usuario create(Usuario usuario) {
		String passwordEncoder = encoder.encode(usuario.getPassword());
		usuario.setPassword(passwordEncoder);
				
		return repository.save(usuario);
	}
	
	public UsuarioDTO findId(UUID id) {
		Optional<Usuario> usuarioOptional = repository.findById(id);
		Usuario usuario = usuarioOptional.get();
		if(!usuarioOptional.isPresent()) {
			throw new EntityNotFoundException("Entidade não encontrada");
		}

		UsuarioDTO dto = UsuarioDTOMapper.from(usuario);
		return dto;
	
	}
	
	public void salvarMuitos(UUID usuarioID, UUID roleId) {
		Usuario usuario = repository.findById(usuarioID)
				.orElseThrow(() -> new EntityNotFoundException("Usuario não encontrada"));
		RoleModel role = roleRepository.findById(roleId)
				.orElseThrow(() -> new EntityNotFoundException("Role não encontrada"));
		
		usuario.getRole().add(role);
		repository.save(usuario);
	}
}
