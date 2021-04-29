package com.zup.desafioorange.controller.request;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CreateVaccineRequest {
	
	@NotBlank(message = "The field name is required")
	private String name;
	
	@NotNull (message = "The filed applicationDate is required")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate applicationDate;
	
	@NotBlank (message = "The field email is required")
	@Email
	private String email;

	public CreateVaccineRequest() {
		
	}

	public CreateVaccineRequest(String name, LocalDate applicationDate, String email) {
		super();
		this.name = name;
		this.applicationDate = applicationDate;
		this.email = email;
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
	
	public void setEmail (String email) {
		this.email = email;
		
	}
	
	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicationDate == null) ? 0 : applicationDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateVaccineRequest other = (CreateVaccineRequest) obj;
		if (applicationDate == null) {
			if (other.applicationDate != null)
				return false;
		} else if (!applicationDate.equals(other.applicationDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
