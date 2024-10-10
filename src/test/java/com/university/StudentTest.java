package com.university;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentTest {

    private Student student;

    @BeforeEach
    public void setUp() {
        student = new Student("Jane Doe", 0, "jane@example.com");
    }

    @Test
    public void testStudentCreation() {
        assertEquals("Jane Doe", student.getName());
        assertEquals("jane@example.com", student.getEmail());
        assertEquals(0, student.getCourseCount());
    }

    @Test
    public void testAddToCourse() {
        Course course = new Course(101, new Teacher("John Smith", "History", 4321));
        student.addToCourse(course);

        assertEquals(1, student.getCourseCount());
        assertEquals(course, student.getCourses().get(0));
    }
}
