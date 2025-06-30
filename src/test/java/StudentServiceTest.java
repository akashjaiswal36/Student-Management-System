package com.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    private StudentService service;

    @Mock
    private StudentRepository repo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new StudentService(repo);
    }

    @Test
    void saveDelegatesToRepository() {
        Student s = new Student(5, "Carl", "DevOps");
        service.save(s);

        ArgumentCaptor<Student> captor = ArgumentCaptor.forClass(Student.class);
        verify(repo).save(captor.capture());

        assertThat(captor.getValue().getName()).isEqualTo("Carl");
    }

    @Test
    void findAllReturnsRepoResults() {
        when(repo.findAll()).thenReturn(
            List.of(new Student(1, "A", "X"))
        );

        assertThat(service.findAll())
            .extracting(Student::getId)
            .containsExactly(1);
    }

    @Test
    void findByIdReturnsNullWhenMissing() {
        when(repo.findById(99)).thenReturn(Optional.empty());
        assertThat(service.findById(99)).isNull();
    }
}
