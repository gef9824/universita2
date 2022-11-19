package com.example.universita2.service;

import com.example.universita2.entity.Student;
import com.example.universita2.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        Student student = Student.builder()
                .studentId(1L)
                .matricola("A01")
                .studentName("Gennaro")
                .studentSurname("De Rosa")
                .build();

        Mockito.when(studentRepository.findByStudentNameIgnoreCase("Gennaro")).thenReturn(student);
    }
    @Test
    @DisplayName("Get validation on FindName")
    public void whenValidStudentName_thenStudentShouldFound(){
        String studentName = "Gennaro";
        Student found = studentService.getStudentByName(studentName);
        assertEquals(studentName,found.getStudentName());
    }
}