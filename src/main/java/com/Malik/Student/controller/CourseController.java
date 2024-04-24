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
import com.Malik.Student.model.CourseDto;
import com.Malik.Student.model.Semester;
import com.Malik.Student.repository.AcademicUnitRepository;
import com.Malik.Student.repository.CourseRepository;
import com.Malik.Student.repository.SemesterRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/course")
@CrossOrigin("*")
public class CourseController {
	
	@Autowired
	private CourseRepository repo;
	
	@Autowired
	private SemesterRepository semesterRepository;
	
	@Autowired
	private AcademicUnitRepository academicUnitRepository;
	
	//Display All Courses
	@GetMapping
	public List<Course> getAllCourses(){
		return repo.findAll();
	}
	//Display Course According to the ID
	@GetMapping("{id}")
	public ResponseEntity<Object> getCourses(@PathVariable Long id){
		Course course = repo.findById(id).orElse(null);
		if (course == null) {
	        return new ResponseEntity<>("Student with ID " + id + " not found", HttpStatus.NOT_FOUND);
	    } else {
	        return ResponseEntity.ok(course);
	    }
	}
	
	
	public CourseController(CourseRepository repo, SemesterRepository semesterRepository, AcademicUnitRepository academicUnitRepository) {
        this.repo = repo;
        this.semesterRepository = semesterRepository;
        this.academicUnitRepository = academicUnitRepository;
    }
	
	//create a course
	@PostMapping
	public ResponseEntity<Object> createCourse(@Valid @RequestBody CourseDto courseDto){
	    Course course = new Course();
	    course.setCourseName(courseDto.getCourseName());
	    course.setSemester(courseDto.getSemester());
	    course.setDepartment(courseDto.getDepartment());

	    repo.save(course);
	    return ResponseEntity.ok(course);
	}
	@PutMapping("{id}")
	public ResponseEntity<Object> updateCourse(@PathVariable Long id,@Valid @RequestBody CourseDto courseDto){
		Course course = repo.findById(id).orElse(null);
		if (course == null) {
	        return new ResponseEntity<>("Course with ID " + id + " not found", HttpStatus.NOT_FOUND);
	    }
		course.setCourseName(courseDto.getCourseName());
	    course.setSemester(courseDto.getSemester());
	    course.setDepartment(courseDto.getDepartment());
	    repo.save(course);
	    return ResponseEntity.ok(course);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteCourse(@PathVariable Long id){
		Course course = repo.findById(id).orElse(null);
		if (course == null) {
	        return new ResponseEntity<>("Course with ID " + id + " not found", HttpStatus.NOT_FOUND);
	    }
		repo.delete(course);
		return ResponseEntity.status(HttpStatus.OK).body("Course with id " + id + " deleted successfully");

	}


}
