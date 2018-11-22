package com.ex.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity // registers class as entity in DB
@Table(name="USERS") // allows further configuration of the table in the DB
public class User implements Serializable {
	
	private static final long serialVersionUID = 11;
	
	@Id 
	@Column(name = "USER_ID")
	@SequenceGenerator(name = "USER_SEQ_GEN", sequenceName = "U_SEQ") 
	@GeneratedValue(generator = "USER_SEQ_GEN", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false, name = "FIRST_NAME")
	private String firstName;
	
	@Column(nullable = false, name = "LAST_NAME")
	private String lastName;
	
	public User() {}

	public User(String username, String password, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	};
	
	
	@Override
	public String toString() {
		return username + ": " + firstName + " " + lastName;
	}
	
	
}


	
