package io.github.filme.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.filme.domain.entity.RoleModel;
import io.github.filme.service.impl.RoleServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/role")
public class RoleController {

	
	@Autowired
	RoleServiceImpl service;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public RoleModel criar(@RequestBody @Valid RoleModel role) {
		return service.save(role);
	}
}
