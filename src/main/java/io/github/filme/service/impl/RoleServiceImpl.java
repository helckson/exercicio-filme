package io.github.filme.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import io.github.filme.domain.entity.RoleModel;
import io.github.filme.domain.repository.RoleRepository;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class RoleServiceImpl {
	
	@Autowired
	RoleRepository repository;
	
	public RoleModel save(RoleModel role) {
		return repository.save(role);
	}
}
