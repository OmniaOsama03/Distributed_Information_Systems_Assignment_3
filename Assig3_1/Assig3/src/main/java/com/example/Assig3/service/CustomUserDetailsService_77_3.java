package com.example.Assig3.service;


import com.example.Assig3.model.Auth_77_3;
import com.example.Assig3.repository.AuthRepository_77_3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//Omnia Osama Ahmed 1084505
//Maryam Mohammed Ali 1079679
//Nourhan Ahmed Elmehalawy 1078096

@Service
public class CustomUserDetailsService_77_3 implements UserDetailsService{

	@Autowired
	private AuthRepository_77_3 userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Auth_77_3 user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		
		return new CustomUserDetails_77_3(user);


	}
	
}
