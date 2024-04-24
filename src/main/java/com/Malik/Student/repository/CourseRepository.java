package com.Malik.Student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Malik.Student.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
