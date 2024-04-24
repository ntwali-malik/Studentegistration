package com.Malik.Student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Malik.Student.model.StudentRegistration;

public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration, Long> {

}
