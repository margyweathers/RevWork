package com.revature.projos;

public class Genre {
	
	private int id;
	private String name;
	
	public Genre() {}

	public Genre(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	};
	
	@Override
	public String toString() {
		return name + "(id:" + id + ")";
	}
	
	

}
