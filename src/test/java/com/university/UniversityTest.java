package com.university;

import com.university.entity.classroom.Course;
import com.university.entity.classroom.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

public class UniversityTest {
    private University university;
    private Student student1;
    private Student student2;
    private Course course1;
    private Course course2;

    @BeforeEach
    public void setUp() {
        university = new University();
        student1 = new Student("Alice Johnson", "alice.johnson@example.com");
        student2 = new Student("Bob Smith", "bob.smith@example.com");
        course1 = new Course(101, "Mathematics");
        course2 = new Course(102, "Physics");
    }

    @Test
    public void testAddStudent() {
        university.getStudents().add(student1);
        List<Student> students = university.getStudents();
        assertEquals(1, students.size());
        assertTrue(students.contains(student1));
    }

    @Test
    public void testAddMultipleStudents() {
        university.getStudents().add(student1);
        university.getStudents().add(student2);
        List<Student> students = university.getStudents();
        assertEquals(2, students.size());
        assertTrue(students.contains(student1));
        assertTrue(students.contains(student2));
    }

    @Test
    public void testAddCourse() {
        university.getCourses().add(course1);
        List<Course> courses = university.getCourses();
        assertEquals(1, courses.size());
        assertTrue(courses.contains(course1));
    }

    @Test
    public void testGetStudentCourseCounts() {
        university.getStudents().add(student1);
        university.getStudents().add(student2);
        student1.addToCourse(course1);
        student1.addToCourse(course2);
        student2.addToCourse(course1);
        Map<String, Integer> studentCounts = university.getStudentCourseCounts();
        assertEquals(2, studentCounts.get("Alice Johnson"));
        assertEquals(1, studentCounts.get("Bob Smith"));
    }
}
