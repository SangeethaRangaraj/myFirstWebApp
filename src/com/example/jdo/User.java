package com.example.jdo;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@PrimaryKey
	@Persistent
	private String username;

	@Persistent
	private String firstname;

	@Persistent
	private String lastname;

	@Persistent
	private String password;

	@Persistent
	private String phonenumber;

	@Persistent
	private String email;

	public User(String username, String firstname, String lastname,
			String password, String phonenumber, String email) {

		this.setUsername(username);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setPassword(password);
		this.setPhonenumber(phonenumber);
		this.setEmail(email);

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
