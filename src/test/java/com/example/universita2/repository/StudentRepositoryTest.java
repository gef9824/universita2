package com.example.universita2.repository;

import com.example.universita2.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Student student =
                Student.builder()
                        .matricola("A02")
                        .studentName("Claudia")
                        .studentSurname("Federico")
                        .build();

        entityManager.persist(student);
    }
    @Test
    public void whenfindByStudentNameIgnoreCase_thenReturnStudent(){
        Student student = studentRepository.findByStudentNameIgnoreCase("Claudia");
        assertEquals(student.getStudentName(),"Claudia");
    }
}