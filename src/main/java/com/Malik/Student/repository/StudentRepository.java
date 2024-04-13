package com.Malik.Student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Malik.Student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
