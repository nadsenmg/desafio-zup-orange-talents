package com.zup.desafioorange.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zup.desafioorange.controller.request.CreateVaccineRequest;
import com.zup.desafioorange.model.Vaccine;
import com.zup.desafioorange.service.VaccineService;

@RestController
public class VaccineController {
	
	private VaccineService vaccineService;
	
	public VaccineController(VaccineService vaccineService) {
		this.vaccineService = vaccineService;
	}
	
	@PostMapping (value = "/vaccine", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void insertVaccine(@RequestBody @Valid CreateVaccineRequest createVaccineRequest) {
		this.vaccineService.insertVaccine(new Vaccine (UUID.randomUUID(), createVaccineRequest.getName(), 
											createVaccineRequest.getEmail(), createVaccineRequest.getApplicationDate()));
	}
}
