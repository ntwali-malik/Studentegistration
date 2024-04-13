package com.Malik.Student.model;

import java.util.Date;

public class SemesterDto {
	
	private int semester_id;
	private String semester_name;
	private Date starting_date;
	private Date end_date;
	public int getSemester_id() {
		return semester_id;
	}
	public void setSemester_id(int semester_id) {
		this.semester_id = semester_id;
	}
	public String getSemester_name() {
		return semester_name;
	}
	public void setSemester_name(String semester_name) {
		this.semester_name = semester_name;
	}
	public Date getStarting_date() {
		return starting_date;
	}
	public void setStarting_date(Date starting_date) {
		this.starting_date = starting_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

}
