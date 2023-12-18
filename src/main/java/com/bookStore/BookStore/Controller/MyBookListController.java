package com.bookStore.BookStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.BookStore.Service.BookService;
import com.bookStore.BookStore.Service.MyBookListService;

@Controller
public class MyBookListController {
	
	@Autowired
	private MyBookListService service;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/deleteMyAdminList/{id}")
	public String deleteMyAdminList(@PathVariable("id") String id) {
		bookService.deleteById(id);
		return "redirect:/admin_available_books";
	}
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") String id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}
}
