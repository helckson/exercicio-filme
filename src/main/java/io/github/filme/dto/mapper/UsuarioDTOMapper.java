package io.github.filme.dto.mapper;

import io.github.filme.domain.entity.Usuario;
import io.github.filme.rest.dto.UsuarioDTO;

public class UsuarioDTOMapper {

	public static UsuarioDTO from(Usuario usuario) {
		UsuarioDTO dto = UsuarioDTO
							.builder()
							.username(usuario.getUsername())
							.role(usuario.getRole())
							.build();
		return dto;
	}
	
}
