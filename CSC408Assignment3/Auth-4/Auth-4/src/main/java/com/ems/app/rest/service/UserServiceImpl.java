package com.ems.app.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ems.app.rest.dto.UserDto;
import com.ems.app.rest.model.User;
import com.ems.app.rest.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User save(UserDto userDto) {
		User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword())  , userDto.getRole(), userDto.getFullname());
		return userRepository.save(user);
	}

}
