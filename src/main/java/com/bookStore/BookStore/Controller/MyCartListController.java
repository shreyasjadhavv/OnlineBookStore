package com.bookStore.BookStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.BookStore.Service.MyCartListService;

@Controller
public class MyCartListController {
	
	@Autowired
	private MyCartListService service;
	
	@RequestMapping("/deleteMyCartList/{id}")
	public String deleteMyCartList(@PathVariable("id") String id) {
		service.deleteById(id);
		return "redirect:/my_cart";
	}
}
