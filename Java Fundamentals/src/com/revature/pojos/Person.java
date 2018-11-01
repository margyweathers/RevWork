package com.revature.pojos;
// pogo: Plain Ol Java Objects
//Almost like "Java Beans" but less strict on conventional rules

public class Person {

	private String name;
	private String hobby;
	private int age;
	
	// No args constructor. Need to explicitly write it since we made a regular constructor
	public Person() {}
	
	// source --> generate constructor using fields
	public Person(String name, String hobby, int age) {
		super();
		this.name = name;
		this.hobby = hobby;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", hobby=" + hobby + ", age=" + age
				+ "]";
	}
	
	
	
}
