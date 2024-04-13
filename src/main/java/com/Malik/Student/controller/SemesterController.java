package com.Malik.Student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Malik.Student.model.Semester;
import com.Malik.Student.model.SemesterDto;
import com.Malik.Student.repository.SemesterRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/semester")
public class SemesterController {
	
	@Autowired
	private SemesterRepository repo ;
	
	//Dislpaying All Semester
	@GetMapping
	public List<Semester> getSemester(){
		return repo.findAll();
	}
	
	//Display Semester Based on ID
	@GetMapping("{id}")
	public ResponseEntity<Object> getSemester(@PathVariable int id){
		
		Semester semester = repo.findById(id).orElse(null);
		
		if(semester == null) {
			return new ResponseEntity<>("Semester with ID " + id + " not found", HttpStatus.NOT_FOUND);
	    } else {
	        return ResponseEntity.ok(semester);
	    }
	}
	
	//Save A Semester
	
	@PostMapping
	public ResponseEntity<Object> saveSemester(@Valid @RequestBody SemesterDto semesterDto){
		
		Semester semester = new Semester();
		semester.setSemester_id(semesterDto.getSemester_id());
		semester.setSemester_name(semesterDto.getSemester_name());
		semester.setStarting_date(semesterDto.getStarting_date());
		semester.setEnd_date(semesterDto.getEnd_date());
		
		repo.save(semester);
		
		return ResponseEntity.ok(semester);
	}
	
	//Upadeting Semester
	
	@PutMapping("{id}")
	public ResponseEntity<Object> updateSemester(@PathVariable int id,@Valid @RequestBody SemesterDto semesterDto){
		Semester semester = repo.findById(id).orElse(null);
		if(semester == null) {
			return new ResponseEntity<>("Semester with ID " + id + " not found", HttpStatus.NOT_FOUND);
	    }
		semester.setSemester_id(semesterDto.getSemester_id());
		semester.setSemester_name(semesterDto.getSemester_name());
		semester.setStarting_date(semesterDto.getStarting_date());
		semester.setEnd_date(semesterDto.getEnd_date());
		
		repo.save(semester);
		return ResponseEntity.ok(semester);
	}
	
	//Deleting Semester
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteSemester(@PathVariable int id){
		Semester semester = repo.findById(id).orElse(null);
		if(semester == null) {
			return new ResponseEntity<>("Semester with ID " + id + " not found", HttpStatus.NOT_FOUND);
	    }
		
		repo.delete(semester);
		return ResponseEntity.status(HttpStatus.OK).body("Semester with id " + id + " deleted successfully");
		
	}
	
}
