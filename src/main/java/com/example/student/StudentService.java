package com.example.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> findAll() {
        return repo.findAll();
    }

    public Student findById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Student save(Student s) {
        return repo.save(s);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
