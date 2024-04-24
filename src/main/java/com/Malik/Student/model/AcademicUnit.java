package com.Malik.Student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AcademicUnit {

	@Id
    @Column(name = "academic_unit_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long academicUnitId;
	
	@Column(name = "academic_unit_name")
    private String academicUnitName;

	@Column(name = "academic_unit_type")
    @Enumerated(EnumType.STRING)
    private EAcademicUnit academicUnitType;
	
	@ManyToOne
    @JoinColumn(name = "parent_id")
    private AcademicUnit parentId;

	public Long getAcademicUnitId() {
		return academicUnitId;
	}

	public void setAcademicUnitId(Long academicUnitId) {
		this.academicUnitId = academicUnitId;
	}

	public String getAcademicUnitName() {
		return academicUnitName;
	}

	public void setAcademicUnitName(String academicUnitName) {
		this.academicUnitName = academicUnitName;
	}

	public EAcademicUnit getAcademicUnitType() {
		return academicUnitType;
	}

	public void setAcademicUnitType(EAcademicUnit academicUnitType) {
		this.academicUnitType = academicUnitType;
	}

	public AcademicUnit getParentId() {
		return parentId;
	}

	public void setParentId(AcademicUnit parentId) {
		this.parentId = parentId;
	}
}
