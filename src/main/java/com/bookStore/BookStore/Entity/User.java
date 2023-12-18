package com.bookStore.BookStore.Entity;

import com.google.cloud.spring.data.spanner.core.mapping.PrimaryKey;
import com.google.cloud.spring.data.spanner.core.mapping.Table;
import lombok.Data;

@Data
@Table(name = "Users")
public class User {

	@PrimaryKey
	private String email;
	private String password;
	private String role;
	private String fullname;

	public User() {
		super();
	}

	public User(String email, String password, String role, String fullname) {

		this.email = email;
		this.password = password;
		this.role = role;
		this.fullname = fullname;
	}


	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}
