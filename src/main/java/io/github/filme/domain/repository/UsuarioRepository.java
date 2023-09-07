package io.github.filme.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import io.github.filme.domain.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{

	UserDetails findByUsername(String username);
}
