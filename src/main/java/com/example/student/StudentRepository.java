package com.example.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    // inherits basic CRUD methods: save, findById, findAll, deleteById, etc.
}
