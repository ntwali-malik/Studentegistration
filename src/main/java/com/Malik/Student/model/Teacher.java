package com.Malik.Student.model;

import jakarta.persistence.*;

@Entity
public class Teacher {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="teacher_id")
    private Long Id;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Enumerated(EnumType.STRING)
    @Column(name="qualification")
    private EQualification qualification;
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

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
