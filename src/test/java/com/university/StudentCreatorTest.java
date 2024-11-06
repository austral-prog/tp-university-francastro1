package com.university;
import static org.junit.jupiter.api.Assertions.*;

import com.university.Creator.StudentCreator;
import com.university.entity.classroom.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentCreatorTest {
    private List<Student> students;
    private University university;
    private StudentCreator studentCreator;

    @BeforeEach
    public void setUp() {
        students = new ArrayList<>();
        university = new University();
        studentCreator = new StudentCreator(students);
    }

    @Test
    public void testGetOrCreate() {
        String studentName = "Alice";
        String email = "alice@example.com";
        String inputData = "Some, data, " + studentName + ", " + email;
        Student student = studentCreator.getOrCreate(inputData, students, university);
        assertEquals(studentName, student.getName());
        assertEquals(email, student.getEmail());
        assertTrue(students.contains(student));
    }

    @Test
    public void testGetOrCreateWhenStudentAlreadyExists() {
        String studentName = "Bob";
        String email = "bob@example.com";
        String inputData = "Some, data, " + studentName + ", " + email;
        studentCreator.getOrCreate(inputData, students, university);
        Student student = studentCreator.getOrCreate(inputData, students, university);
        assertEquals(studentName, student.getName());
        assertEquals(email, student.getEmail());
        assertEquals(1, students.size());
    }

    @Test
    public void testGetOrCreateWithDifferentData() {
        String studentName1 = "Charlie";
        String email1 = "charlie@example.com";
        String inputData1 = "Some, data, " + studentName1 + ", " + email1;
        String studentName2 = "David";
        String email2 = "david@example.com";
        String inputData2 = "Some, data, " + studentName2 + ", " + email2;
        studentCreator.getOrCreate(inputData1, students, university);
        studentCreator.getOrCreate(inputData2, students, university);
        assertEquals(2, students.size());
        assertTrue(students.stream().anyMatch(s -> s.getName().equals(studentName1)));
        assertTrue(students.stream().anyMatch(s -> s.getName().equals(studentName2)));
    }

}
