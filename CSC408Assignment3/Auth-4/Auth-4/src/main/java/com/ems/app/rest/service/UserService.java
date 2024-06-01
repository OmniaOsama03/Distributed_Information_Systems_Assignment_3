package com.ems.app.rest.service;

import com.ems.app.rest.dto.UserDto;
import com.ems.app.rest.model.User;

public interface UserService {
	
User save(UserDto userDto);
}
