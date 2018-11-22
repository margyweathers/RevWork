package com.ex.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="BOG_POST")
public class Post {
	
	@Id 
	@Column(name = "POST_ID")
	@SequenceGenerator(name = "POST_SEQ_GEN", sequenceName = "P_SEQ") 
	@GeneratedValue(generator = "POST_SEQ_GEN", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Size(max=60)
	private String subject;
	
	@Column(nullable = false)
	private String body;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "AUTHOR_ID")
	private User author;	// Have a relationship between objects in Hibernate

	public Post() {}
	
	public Post(String subject, String body, User author) {
		super();
		this.subject = subject;
		this.body = body;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", subject=" + subject + ", body=" + body + ", author=" + author + "]";
	}
	
	
	
	
	
	
	
	
}
