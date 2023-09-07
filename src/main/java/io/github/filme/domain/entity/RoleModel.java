package io.github.filme.domain.entity;

import java.util.UUID;


import org.springframework.security.core.GrantedAuthority;

import io.github.filme.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "role")
public class RoleModel implements GrantedAuthority{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
	private Role role;

	@Override
	public String getAuthority() {
		return this.role.toString();
	}
}
