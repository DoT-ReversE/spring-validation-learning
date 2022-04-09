package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User saveUser(UserRequest userRequest) {
		User user = User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(),
				userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
		return repository.save(user);
	}
	
	public List<User> getAllUsers() {
		return repository.findAll();
	}
	
	public User getUser(int id) throws UserNotFoundException {
		Optional<User> user = repository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new UserNotFoundException("user not found with id : " + id);
		}
	}
}
