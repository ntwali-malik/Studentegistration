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

import com.Malik.Student.model.Course;
import com.Malik.Student.model.CourseDefinition;
import com.Malik.Student.model.CourseDefinitionDto;
import com.Malik.Student.model.Teacher;
import com.Malik.Student.model.TeacherDto;
import com.Malik.Student.repository.CourseDefinitionRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/courseDefinition")
@CrossOrigin("*")
public class CourseDefinitionController {
	
	@Autowired
	private CourseDefinitionRepository repo;
	
	//Display All course Definitions
		@GetMapping
		public List<CourseDefinition> getAllCourseDefinitions(){
			return repo.findAll();
		}
		//Display All course Definitions By ID
		@GetMapping("{id}")
		public ResponseEntity<Object> getCourseDefinitions(@PathVariable Long id){
			CourseDefinition courseDef = repo.findById(id).orElse(null);
			if (courseDef == null) {
		        return new ResponseEntity<>("Course Definition with ID " + id + " not found", HttpStatus.NOT_FOUND);
		    } else {
		        return ResponseEntity.ok(courseDef);
		    }
		}
		//Save A CourseDefinition
		@PostMapping
		public ResponseEntity<Object> createCourseDefinition(@Valid @RequestBody CourseDefinitionDto courseDefinitionDto){
		    Course course = courseDefinitionDto.getCourse();
		    if (course.getId() == null) {
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Course object must have an ID.");
		    }
		    CourseDefinition courseDef = new CourseDefinition();
		    courseDef.setDescription(courseDefinitionDto.getDescription());
		    courseDef.setCourse(course);
		    repo.save(courseDef);

		    return ResponseEntity.ok(courseDef);
		}
		
		@PutMapping("{id}")
		public ResponseEntity<Object> updateCourseDefinition(@PathVariable Long id,@Valid @RequestBody CourseDefinitionDto courseDefinitionDto){
			 Course course = courseDefinitionDto.getCourse();
			 CourseDefinition courseDef = repo.findById(id).orElse(null);
			if (courseDef == null) {
		        return new ResponseEntity<>("Course Definition with ID " + id + " not found", HttpStatus.NOT_FOUND);
		    }
			courseDef.setDescription(courseDefinitionDto.getDescription());
		    courseDef.setCourse(course);
		    repo.save(courseDef);
		    
		    return ResponseEntity.ok(courseDef);
		}
		@DeleteMapping("{id}")
		public ResponseEntity<Object> deleteCourseDefinition(@PathVariable Long id){
			CourseDefinition courseDef = repo.findById(id).orElse(null);
			if (courseDef == null) {
		        return new ResponseEntity<>("Course Definition with ID " + id + " not found", HttpStatus.NOT_FOUND);
		    }
			repo.delete(courseDef);
			return ResponseEntity.status(HttpStatus.OK).body("Teacher with id " + id + " deleted successfully");
		}
}
