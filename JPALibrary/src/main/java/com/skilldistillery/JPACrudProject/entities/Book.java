package com.skilldistillery.JPACrudProject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private Boolean completed;
	
	@Column(name="checkin_status")
	private String checkinStatus;
	
	public Book() {
		
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
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public String getCheckinStatus() {
		return checkinStatus;
	}

	public void setCheckinStatus(String checkinStatus) {
		this.checkinStatus = checkinStatus;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", " + (name != null ? "name=" + name + ", " : "")
				+ (completed != null ? "completed=" + completed + ", " : "")
				+ (checkinStatus != null ? "checkinStatus=" + checkinStatus : "") + "]";
	}
	
	
}
