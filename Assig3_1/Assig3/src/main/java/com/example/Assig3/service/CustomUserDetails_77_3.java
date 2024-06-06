package com.example.Assig3.service;


import java.util.Collection;
import java.util.List;


import com.example.Assig3.model.Auth_77_3;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


//Omnia Osama Ahmed 1084505
//Maryam Mohammed Ali 1079679
//Nourhan Ahmed Elmehalawy 1078096

public class CustomUserDetails_77_3 implements UserDetails {

	private Auth_77_3 user;
	
	public CustomUserDetails_77_3(Auth_77_3 user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(() -> user.getRole());
	}

	public String getFullname() {
		return user.getFullname();
	}

	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
