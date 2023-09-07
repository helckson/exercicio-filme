package io.github.filme.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.filme.domain.entity.Filme;

public interface FilmeRepository extends JpaRepository<Filme, UUID>{

}
