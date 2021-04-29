package com.zup.desafioorange.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zup.desafioorange.exception.UserNotFoundException;
import com.zup.desafioorange.model.User;
import com.zup.desafioorange.model.Vaccine;
import com.zup.desafioorange.repository.UserRepository;
import com.zup.desafioorange.repository.VaccineRepository;

@Service
public class VaccineService {

	private VaccineRepository vaccineRepository;
	private UserRepository userRepository;

	public VaccineService(UserRepository userRepository, VaccineRepository vaccineRepository) {
		this.userRepository = userRepository;
		this.vaccineRepository = vaccineRepository;
	}
	
	public void insertVaccine(Vaccine vaccine) {
		Optional<User> user = this.userRepository.findByEmail(vaccine.getEmail()); 
		if(user.isPresent()) {
			vaccineRepository.save(vaccine);
		} else {
			throw new UserNotFoundException("User not found");
		}	
	}
}
