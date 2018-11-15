package com.ex.pojos;

public class BookInfo {
	// b.book_id, b.isbn, a.first_name, a.last_name, b.title, b.price, g.name

	private int id;
	private String isbn; 
	private String fn;
	private String ln;
	private String title; 
	private double price;
	private String genre;
	
	public BookInfo() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "BookInfo [id=" + id + ", isbn=" + isbn + ", fn=" + fn + ", ln=" + ln + ", title=" + title + ", price="
				+ price + ", genre=" + genre + "]";
	}
	
	
}
