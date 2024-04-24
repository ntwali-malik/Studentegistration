package com.Malik.Student.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CourseDto {

	private String courseName;
    private Semester semester;
    private AcademicUnit department;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
