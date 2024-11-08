package com.university.entityTest;

import static org.junit.jupiter.api.Assertions.*;

import com.university.entity.classroom.Course;
import com.university.entity.classroom.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {

    private Student student;
    private Course course;
    @BeforeEach
    public void setUp() {
        student = new Student("Jane Doe","jane@example.com");
        course = new Course(505,"Math");
    }

    @Test
    public void testStudentCreation() {
        assertEquals("Jane Doe", student.getName());
        assertEquals("jane@example.com", student.getEmail());
        assertEquals(0, student.getCourseCount());
        student.setName("Alice");
        student.setEmail("alice@example.com");
        student.addToCourse(course);
        assertEquals(1, student.getCourseCount());
        assertEquals("Alice", student.getName());
        assertEquals("alice@example.com", student.getEmail());
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        assertEquals(courses.size(), student.getCourses().size());
    }

    @Test
    public void testAddToCourse() {
        Course course = new Course(101, "History");
        student.addToCourse(course);
        assertEquals(1, student.getCourseCount());
    }
}
