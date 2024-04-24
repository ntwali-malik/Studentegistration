package com.Malik.Student.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class StudentRegistration {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "registration_id")
    private Long registrationId;
    
    @Column(name = "registration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    private AcademicUnit department;

	public Long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}

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
