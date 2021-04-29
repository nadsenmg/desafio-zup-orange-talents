package com.zup.desafioorange.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vaccine {

	@Id
	@GeneratedValue
	private UUID id;

	private String name;
	
	private String email;

	private LocalDate date;
	
	public Vaccine(UUID id, String name, String email, LocalDate date) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.date = date;
	}

	//Getters and Setters
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}