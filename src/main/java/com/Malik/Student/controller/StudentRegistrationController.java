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
import com.Malik.Student.model.Course;
import com.Malik.Student.model.CourseDefinition;
import com.Malik.Student.model.CourseDefinitionDto;
import com.Malik.Student.model.Semester;
import com.Malik.Student.model.Student;
import com.Malik.Student.model.StudentRegistration;
import com.Malik.Student.model.StudentRegistrationDto;
import com.Malik.Student.repository.StudentRegistrationRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/studentRegistration")
@CrossOrigin("*")
public class StudentRegistrationController {
	
	@Autowired
	private StudentRegistrationRepository repo;
	
	//Display All course Definitions
	@GetMapping
	public List<StudentRegistration> getAllStudentRegistrations(){
			return repo.findAll();
	}
	//Display All course Definitions By ID
	@GetMapping("{registrationId}")
	public ResponseEntity<Object> getStudentRegistrations(@PathVariable Long registrationId){
				StudentRegistration studentRegistration = repo.findById(registrationId).orElse(null);
				if (studentRegistration == null) {
			        return new ResponseEntity<>("Course Definition with ID " + registrationId + " not found", HttpStatus.NOT_FOUND);
			    } else {
			        return ResponseEntity.ok(studentRegistration);
			    }
			}
			//Save A CourseDefinition
			@PostMapping
			public ResponseEntity<Object> createStudentRegistration(@Valid @RequestBody StudentRegistrationDto studentRegistrationDto){
			    // Retrieve the Course object from the DTO
			    Semester semester = studentRegistrationDto.getSemester();
			    AcademicUnit department = studentRegistrationDto.getDepartment();
			    Student student = studentRegistrationDto.getStudent();
			    StudentRegistration studentRegistration = new StudentRegistration();
			    studentRegistration.setStudent(student);
			    studentRegistration.setDepartment(department);
			    studentRegistration.setSemester(semester);
			    studentRegistration.setRegistrationDate(studentRegistrationDto.getRegistrationDate());
			    repo.save(studentRegistration);

			    return ResponseEntity.ok(studentRegistration);
			}
			
			@PutMapping("{registrationId}")
			public ResponseEntity<Object> updateStudentRegistration(@PathVariable Long registrationId,@Valid @RequestBody StudentRegistrationDto studentRegistrationDto){
				
				StudentRegistration studentRegistration = repo.findById(registrationId).orElse(null);
				if (studentRegistration == null) {
			        return new ResponseEntity<>("Course Definition with ID " + registrationId + " not found", HttpStatus.NOT_FOUND);
			    }
				
				Semester semester = studentRegistrationDto.getSemester();
				AcademicUnit department = studentRegistrationDto.getDepartment();
				Student student = studentRegistrationDto.getStudent();
				studentRegistration.setStudent(student);
				studentRegistration.setDepartment(department);
				studentRegistration.setSemester(semester);
				studentRegistration.setRegistrationDate(studentRegistrationDto.getRegistrationDate());
				
				repo.save(studentRegistration);
				
				return ResponseEntity.ok(studentRegistration);
			}
			@DeleteMapping("{registrationId}")
			public ResponseEntity<Object> deleteStudentRegistration(@PathVariable Long registrationId){
				StudentRegistration studentRegistration = repo.findById(registrationId).orElse(null);
				if (studentRegistration == null) {
			        return new ResponseEntity<>("Student REgistration with ID " + registrationId + " not found", HttpStatus.NOT_FOUND);
			    }
				repo.delete(studentRegistration);
				return ResponseEntity.status(HttpStatus.OK).body("Student REgistration with id " + registrationId + " deleted successfully");
			}
	
	

}
