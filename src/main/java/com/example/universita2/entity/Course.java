package com.example.universita2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long courseId;
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "docente_id",referencedColumnName = "teacherId")
    private Teacher teacher;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_COURSE",joinColumns = {
            @JoinColumn(name = "course_id",referencedColumnName = "courseId")
    },
            inverseJoinColumns = {
                    @JoinColumn(name = "student_id",referencedColumnName = "studentId")
            }
    )
    private Set<Student> students;
}
