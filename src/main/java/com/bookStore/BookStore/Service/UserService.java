package com.bookStore.BookStore.Service;


import com.bookStore.BookStore.Entity.*;
import com.bookStore.BookStore.dto.UserDto;


public interface UserService {
	
	User save (UserDto userDto);

}