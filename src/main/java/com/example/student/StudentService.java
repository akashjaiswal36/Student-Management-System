package com.example.student;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class StudentService {
    private final Map<Integer, Student> db = new ConcurrentHashMap<>();

    public List<Student> findAll()             { return new ArrayList<>(db.values()); }
    public Student findById(int id)            { return db.get(id); }
    public Student save(Student s)             { return db.put(s.getId(), s); }
    public Student delete(int id)              { return db.remove(id); }
}
