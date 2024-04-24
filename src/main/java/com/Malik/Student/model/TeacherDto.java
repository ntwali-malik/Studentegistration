package com.Malik.Student.model;

public class TeacherDto {
	private String firstName;
	private String lastName;
	private EQualification qualification;
	private Course course;
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
	}
	public EQualification getQualification() {
		return qualification;
	}
	public void setQualification(EQualification qualification) {
		this.qualification = qualification;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
}
