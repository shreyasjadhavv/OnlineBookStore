package com.bookStore.BookStore.Service;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookStore.BookStore.Entity.*;
import com.bookStore.BookStore.dto.UserDto;
import com.bookStore.BookStore.repository.*;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(UserDto userDto) {
		User user = new User(userDto.getEmail(), userDto.getPassword() , userDto.getRole(), userDto.getFullname());
		return userRepository.save(user);
	}

}
