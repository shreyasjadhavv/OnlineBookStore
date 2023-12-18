package com.bookStore.BookStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.BookStore.Entity.MyCartList;
import com.bookStore.BookStore.repository.MyCartRepository;

@Service
public class MyCartListService {
	
	@Autowired
	private MyCartRepository myCart;
	
	public void saveMyBooks(MyCartList cart) {
		myCart.save(cart);
	}
	
	public List<MyCartList> getAllMyBooks(){
		return (List<MyCartList>) myCart.findAll();
	}
	
	public void deleteById(String id) {
		myCart.deleteById(id);
	}
}
