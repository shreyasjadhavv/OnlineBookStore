package com.bookStore.BookStore.Entity;

import com.google.cloud.spring.data.spanner.core.mapping.PrimaryKey;
import com.google.cloud.spring.data.spanner.core.mapping.Table;

import lombok.Data;

@Table(name = "MyBooks")
@Data
public class MyBookList {
	
	@PrimaryKey
	private String id;
	private String name;
	private String author;
	private String price;
	public MyBookList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyBookList(String id, String name, String author, String price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
