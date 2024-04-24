package com.Malik.Student.model;

import jakarta.persistence.*;

@Entity
public class CourseDefinition {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_definition_id")
    private Long Id;

    @Column(name ="course_definition_description")
    private String description ;
    

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}
    
    
}
