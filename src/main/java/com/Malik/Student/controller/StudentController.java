package com.Malik.Student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.Malik.Student.model.Student;
import com.Malik.Student.model.StudentDto;
import com.Malik.Student.repository.StudentRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/student")
@CrossOrigin("*")
public class StudentController {

	@Autowired
	private StudentRepository repo;
	
	//Display
	@GetMapping
	public List<Student> getStudents(){
		return repo.findAll();
	}
	
	//Display Student Based on Id
	@GetMapping("{id}")
	public ResponseEntity<Object> getStudent(@PathVariable int id) {
	    Student student = repo.findById(id).orElse(null);
	    if (student == null) {
	        return new ResponseEntity<>("Student with ID " + id + " not found", HttpStatus.NOT_FOUND);
	    } else {
	        return ResponseEntity.ok(student);
	    }
	}

	
	
	//Creating
	@PostMapping
	public ResponseEntity<Object> createStudent(@Valid @RequestBody StudentDto studentDto){
		
		Student student = new Student();
		student.setFirst_name(studentDto.getFirst_name());
		student.setLast_name(studentDto.getLast_name());
		student.setDate_of_birth(studentDto.getDate_of_birth());
		//student.setDate_of_birth(studentDto.getDate_of_birth());
		
		repo.save(student);
		
		return ResponseEntity.ok(student);
		
	}
	
	// UPDATE
	
	@PutMapping("{id}")
	public ResponseEntity<Object> updateStudent(@PathVariable int id, @Valid @RequestBody StudentDto studentDto) {
	    // Retrieve the existing student from the repository
	    Student student = repo.findById(id).orElse(null);
	    if (student == null) {
	        return new ResponseEntity<>("Student with ID " + id + " not found", HttpStatus.NOT_FOUND);
	    }
	    student.setFirst_name(studentDto.getFirst_name());
	    student.setLast_name(studentDto.getLast_name());
	    student.setDate_of_birth(studentDto.getDate_of_birth());
	    repo.save(student);
	    return ResponseEntity.ok(student);
	}
	
	//DELETE
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteStudent (@PathVariable int id){
		Student student = repo.findById(id).orElse(null);
	    if (student == null) {
	        return new ResponseEntity<>("Student with ID " + id + " not found", HttpStatus.NOT_FOUND);
	    }
	    
	    repo.delete(student);
	    return ResponseEntity.status(HttpStatus.OK).body("Student with id " + id + " deleted successfully");
		
	}

	
	
}
