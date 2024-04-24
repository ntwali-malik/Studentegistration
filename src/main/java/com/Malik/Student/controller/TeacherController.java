package com.Malik.Student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Malik.Student.model.Course;
import com.Malik.Student.model.Teacher;
import com.Malik.Student.model.TeacherDto;
import com.Malik.Student.repository.TeacherRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

	@Autowired
	private TeacherRepository repo;
	
	//Display All Teachers
	@GetMapping
	public List<Teacher> getAllTeachers(){
		return repo.findAll();
	}
	
	//Display All Teachers By ID
	@GetMapping("{id}")
	public ResponseEntity<Object> getCourses(@PathVariable Long id){
		Teacher teacher = repo.findById(id).orElse(null);
		if (teacher == null) {
	        return new ResponseEntity<>("Teacher with ID " + id + " not found", HttpStatus.NOT_FOUND);
	    } else {
	        return ResponseEntity.ok(teacher);
	    }
	}
	//Save A Teacher
	@PostMapping
	public ResponseEntity<Object> createTeacher(@Valid @RequestBody TeacherDto teacherDto){
	    Course course = teacherDto.getCourse();
	    if (course.getId() == null) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Course object must have an ID.");
	    }
	    Teacher teacher = new Teacher();
	    teacher.setFirstName(teacherDto.getFirstName());
	    teacher.setLastName(teacherDto.getLastName());
	    teacher.setQualification(teacherDto.getQualification());
	    teacher.setCourse(course);
	    repo.save(teacher);

	    return ResponseEntity.ok(teacher);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Object> updateTeacher(@PathVariable Long id,@Valid @RequestBody TeacherDto teacherDto){
		Course course = teacherDto.getCourse();
		Teacher teacher = repo.findById(id).orElse(null);
		if (teacher == null) {
	        return new ResponseEntity<>("Teacher with ID " + id + " not found", HttpStatus.NOT_FOUND);
	    }
		teacher.setFirstName(teacherDto.getFirstName());
	    teacher.setLastName(teacherDto.getLastName());
	    teacher.setQualification(teacherDto.getQualification());
	    teacher.setCourse(course);
	    repo.save(teacher);
	    
	    return ResponseEntity.ok(teacher);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteTeacher(@PathVariable Long id){
		Teacher teacher = repo.findById(id).orElse(null);
		if (teacher == null) {
	        return new ResponseEntity<>("Teacher with ID " + id + " not found", HttpStatus.NOT_FOUND);
	    }
		repo.delete(teacher);
		return ResponseEntity.status(HttpStatus.OK).body("Teacher with id " + id + " deleted successfully");
	}
	

	
	
}
