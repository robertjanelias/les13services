package com.example.les13services.repository;

import com.example.les13services.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findByLastNameContainingIgnoreCase(String lname);
}
