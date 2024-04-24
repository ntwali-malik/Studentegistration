package com.Malik.Student.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StudentRegistrationDto {

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date registrationDate;
	private Student student;
	private Semester semester;
	private AcademicUnit department;
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	public AcademicUnit getDepartment() {
		return department;
	}
	public void setDepartment(AcademicUnit department) {
		this.department = department;
	}
	
}
