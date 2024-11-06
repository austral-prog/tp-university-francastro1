package com.university;

import static org.junit.jupiter.api.Assertions.*;

import com.university.FileReader.creator.Creator1;
import com.university.entity.classroom.Course;
import com.university.entity.classroom.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Creator1Test {

    private University university;
    private Creator1 creator;
    private List<Student> students;
    private List<Course> courses;

    @BeforeEach
    public void setUp() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        university = new University();
        creator = new Creator1();
    }

    @Test
    public void testCreateStudentAndCourse() {
        String studentName = "Alice";
        String email = "alice@example.com";
        String inputData = studentName + ", " + email;
        creator.create(inputData, university, null);
        assertEquals(1, students.size());
        Student student = students.get(0);
        assertEquals(studentName, student.getName());
        assertEquals(email, student.getEmail());
        assertEquals(1, courses.size());
        Course course = courses.get(0);
        assertTrue(course.getStudents().contains(student));
        assertTrue(student.getCourses().contains(course));
    }

    @Test
    public void testCreateDifferent() {
        String studentName1 = "Charlie";
        String email1 = "charlie@example.com";
        String inputData1 = studentName1 + ", " + email1;
        String studentName2 = "David";
        String email2 = "david@example.com";
        String inputData2 = studentName2 + ", " + email2;
        creator.create(inputData1, university, null);
        creator.create(inputData2, university, null);
        assertEquals(2, students.size());
        assertEquals(2, courses.size());
        Student student1 = students.get(0);
        Student student2 = students.get(1);
        Course course1 = courses.get(0);
        Course course2 = courses.get(1);
        assertTrue(course1.getStudents().contains(student1));
        assertTrue(course2.getStudents().contains(student2));
        assertTrue(student1.getCourses().contains(course1));
        assertTrue(student2.getCourses().contains(course2));
    }
}

