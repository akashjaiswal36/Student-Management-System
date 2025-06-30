package com.example.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)   // loads MVC layer only
class StudentControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper om;

    @MockBean                 // Provide a mocked service
    private StudentService service;

    @Test
    void getAllStudentsReturnsJsonArray() throws Exception {
        when(service.findAll()).thenReturn(
            List.of(new Student(1, "Alice", "Math"))
        );

        mvc.perform(get("/api/students"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].name").value("Alice"));
    }

    @Test
    void postStudentPersistsViaService() throws Exception {
        Student s = new Student(2, "Bob", "AWS");

        mvc.perform(post("/api/students")
              .contentType(MediaType.APPLICATION_JSON)
              .content(om.writeValueAsString(s)))
           .andExpect(status().isCreated());

        verify(service).save(any(Student.class));
    }
}
