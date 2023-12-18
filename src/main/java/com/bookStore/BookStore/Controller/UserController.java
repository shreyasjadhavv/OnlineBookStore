package com.bookStore.BookStore.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookStore.BookStore.Entity.User;
import com.bookStore.BookStore.Service.UserService;
import com.bookStore.BookStore.dto.UserDto;
import com.bookStore.BookStore.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository repo;
	
	
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
		userService.save(userDto);
		model.addAttribute("message", "Registered Successfuly!");
		return "login";
	}
	
	@GetMapping("/login")
	public String login(@ModelAttribute("user") User user) {
		return "login";
	}
	
	@PostMapping("/userLogin")
	public String loginUser(@ModelAttribute("user") User user) {
		String emailId = user.getEmail();
		Optional<User> userData = repo.findById(emailId);
		if(user.getPassword().equals(userData.get().getPassword())) {
			return "home";
		}
		return "error";
	}
	
	@GetMapping("/admin")
	public String admin(@ModelAttribute("user") User user) {
		return "admin";
	}
	
	@PostMapping("/adminLogin")
	public String loginAdmin(@ModelAttribute("user") User user) {
		String emailId = user.getEmail();
		Optional<User> userData = repo.findById(emailId);
		if(user.getPassword().equals(userData.get().getPassword()) && userData.get().getRole().equals("Admin")) {
			return "adminDashboard";
		}
		return "error";
	}

}
