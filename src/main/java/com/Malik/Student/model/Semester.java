package com.Malik.Student.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Semester {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "semester_id")
	private int id;
	private String semester_name;
	private String starting_date;
	private String end_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSemester_name() {
		return semester_name;
	}
	public void setSemester_name(String semester_name) {
		this.semester_name = semester_name;
	}
	public String getStarting_date() {
		return starting_date;
	}
	public void setStarting_date(String starting_date) {
		this.starting_date = starting_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	
	
}
