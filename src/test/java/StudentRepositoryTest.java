package com.example.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest   // starts H2 + configures Spring Data JPA only
class StudentRepositoryTest {

    @Autowired
    private StudentRepository repo;

    @Test
    void saveAndFindById() {
        Student s = new Student(1, "Alice", "Math");
        repo.save(s);

        Optional<Student> found = repo.findById(1);
        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("Alice");
    }

    @Test
    void findAllReturnsAllStudents() {
        repo.save(new Student(1, "A", "Math"));
        repo.save(new Student(2, "B", "AWS"));

        assertThat(repo.findAll()).hasSize(2);
    }
}
