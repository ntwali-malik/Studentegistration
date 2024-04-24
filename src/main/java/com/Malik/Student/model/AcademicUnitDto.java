package com.Malik.Student.model;

public class AcademicUnitDto {

	 private String academicUnitName;
	 private EAcademicUnit academicUnitType;
	 private AcademicUnit parentId;
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
