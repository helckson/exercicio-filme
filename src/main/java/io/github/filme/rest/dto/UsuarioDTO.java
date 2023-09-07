package io.github.filme.rest.dto;

import java.util.List;

import io.github.filme.domain.entity.RoleModel;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UsuarioDTO {

	private String username;

	private List<RoleModel> role;
}
