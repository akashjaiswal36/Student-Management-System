package com.example.student;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController                   // JSON API
@RequestMapping("/api/students") // base URL
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService s) { this.service = s; }

    @GetMapping                public List<Student> all()        { return service.findAll(); }
    @GetMapping("/{id}")       public Student one(@PathVariable int id) {
                                   return service.findById(id);
                               }
    @PostMapping               public Student add(@RequestBody Student s) {
                                   service.save(s); return s;
                               }
    @DeleteMapping("/{id}")    public void delete(@PathVariable int id) {
                                   service.delete(id);
                               }
}
