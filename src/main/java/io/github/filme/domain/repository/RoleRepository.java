package io.github.filme.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.filme.domain.entity.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, UUID>{

}
