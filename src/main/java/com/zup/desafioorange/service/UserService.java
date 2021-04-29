package com.zup.desafioorange.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.zup.desafioorange.model.User;
import com.zup.desafioorange.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void insertUser(User user) {
		userRepository.save(user);
	}
	
	public User findByEmail(String email) {
		Optional<User> LocateEmail = Optional.ofNullable(userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found")));
        return LocateEmail.get();
}
}