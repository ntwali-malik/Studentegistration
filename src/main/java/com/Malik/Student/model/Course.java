package com.Malik.Student.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Course {

	@Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "course_name")
    private String courseName;
    
    @OneToOne
    @JoinColumn(name ="semester_id")
    private Semester semester;
    
    @OneToOne
    @JoinColumn(name = "department_id")
    private AcademicUnit department;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
