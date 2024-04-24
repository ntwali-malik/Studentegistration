package com.Malik.Student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Malik.Student.model.AcademicUnit;
import com.Malik.Student.model.AcademicUnitDto;
import com.Malik.Student.repository.AcademicUnitRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/academicUnit")
@CrossOrigin("*")
public class AcademicUnitController {
	
	@Autowired
	private AcademicUnitRepository repo;
	
	//Display All
	@GetMapping
	public List<AcademicUnit> getAcademicUnits(){
		return repo.findAll();
	}
	
	//Display According to the ID
	@GetMapping("{academicUnitId}")
	public ResponseEntity<Object> getAcademics(@PathVariable Long academicUnitId){
		AcademicUnit academic = repo.findById(academicUnitId).orElse(null);
		if (academic == null) {
	        return new ResponseEntity<>("Student with ID " + academicUnitId + " not found", HttpStatus.NOT_FOUND);
	    } else {
	        return ResponseEntity.ok(academic);
	    }
	}
	
	//Creating
	@PostMapping
	public ResponseEntity<Object> createAcademic(@Valid @RequestBody AcademicUnitDto academicDto){
	    AcademicUnit academic = new AcademicUnit();
	    academic.setAcademicUnitName(academicDto.getAcademicUnitName());
	    academic.setAcademicUnitType(academicDto.getAcademicUnitType());
	    AcademicUnit parentAcademicUnit = academicDto.getParentId();
	    if (parentAcademicUnit != null) {
	        academic.setParentId(parentAcademicUnit);
	    }
	    AcademicUnit savedAcademic = repo.save(academic);
	    return ResponseEntity.ok(savedAcademic);
	}
	
	@PutMapping("{academicUnitId}")
	public ResponseEntity<Object> updateAcademic(@PathVariable Long academicUnitId, @Valid @RequestBody AcademicUnitDto academicDto){
	    AcademicUnit academic = repo.findById(academicUnitId).orElse(null);
	                      
	    if (academic == null) {
	        return new ResponseEntity<>("Academic Unit with ID " + academicUnitId + " not found", HttpStatus.NOT_FOUND);
	    }
	    academic.setAcademicUnitName(academicDto.getAcademicUnitName());
	    academic.setAcademicUnitType(academicDto.getAcademicUnitType());
	    AcademicUnit parentAcademicUnit = academicDto.getParentId();
	    academic.setParentId(parentAcademicUnit);
	    AcademicUnit updatedAcademic = repo.save(academic);
	    
	    return ResponseEntity.ok(updatedAcademic);
	}
	
	@DeleteMapping("{academicUnitId}")
	public ResponseEntity<Object> deleteAcademic(@PathVariable Long academicUnitId){
		AcademicUnit academic = repo.findById(academicUnitId).orElse(null);
		if (academic == null) {
	        return new ResponseEntity<>("Academic Unit with ID " + academicUnitId + " not found", HttpStatus.NOT_FOUND);
	    }
		repo.delete(academic);
		return ResponseEntity.status(HttpStatus.OK).body("Academic Unit with id " + academicUnitId + " deleted successfully");

	}
}
