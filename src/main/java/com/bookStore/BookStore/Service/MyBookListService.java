package com.bookStore.BookStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.BookStore.Entity.MyBookList;
import com.bookStore.BookStore.repository.MyBookRepository;

@Service
public class MyBookListService {
	
	@Autowired
	private MyBookRepository mybook;
	
	public void saveMyBooks(MyBookList book) {
		mybook.save(book);
	}
	
	public List<MyBookList> getAllMyBooks(){
		return (List<MyBookList>) mybook.findAll();
	}
	
	public void deleteById(String id) {
		mybook.deleteById(id);
	}
}
