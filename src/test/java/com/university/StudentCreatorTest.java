package com.university;

import com.university.Creator.StudentCreator;
import com.university.entity.classroom.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentCreatorTest {
    private StudentCreator studentCreator;
    private List<Student> students;

    @BeforeEach
    public void setUp() {
        studentCreator = new StudentCreator();
        students = new ArrayList<>();
    }

    @Test
    public void testGetOrCreateStudentNewStudent() {
        String name = "John Doe";
        String email = "john.doe@example.com";
        Student student = studentCreator.getOrCreateStudent(name, email, students);
        assertEquals(name, student.getName());
        assertEquals(email, student.getEmail());
        assertEquals(1, students.size());
    }

    @Test
    public void testGetOrCreateStudentExistingStudent() {
        String name = "Jane Doe";
        String email = "jane.doe@example.com";
        Student existingStudent = new Student(name, email);
        students.add(existingStudent);
        Student student = studentCreator.getOrCreateStudent(name, email, students);
        assertEquals(existingStudent, student, "Returned student should be the existing student.");
        assertEquals(1, students.size(), "Students list should still contain one student.");
    }
}
