package com.zup.desafioorange.controller;


import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zup.desafioorange.controller.request.CreateUserRequest;
import com.zup.desafioorange.model.User;
import com.zup.desafioorange.service.UserService;

@RestController
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping (value = "/user", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void insertUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
		this.userService.insertUser(new User (UUID.randomUUID(), createUserRequest.getName(), createUserRequest.getEmail(), createUserRequest.getCpf(), createUserRequest.getBirthDate()));
	}
}
