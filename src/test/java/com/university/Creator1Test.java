package com.university;

import com.university.FileReader.creator.Creator1;
import com.university.entity.evaluation.criteria.CriteriaProcessor;
import com.university.entity.classroom.Course;
import com.university.entity.classroom.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Creator1Test {
    private Creator1 creator1;
    private University university;
    private CriteriaProcessor criteriaProcessor;

    @BeforeEach
    public void setUp() {
        creator1 = new Creator1();
        university = new University();
        criteriaProcessor = new CriteriaProcessor();
    }

    @Test
    public void testCreate_NewStudentAndCourse() {
        String[] parts = {"101", "Mathematics", "John Doe", "john.doe@example.com"};
        creator1.create(parts, university, criteriaProcessor);
        List<Student> students = university.getStudents();
        assertEquals(1, students.size());
        assertEquals("John Doe", students.get(0).getName());
        assertEquals("john.doe@example.com", students.get(0).getEmail());
        List<Course> courses = university.getCourses();
        assertEquals(1, courses.size());
        assertEquals("Mathematics", courses.get(0).getName());
        assertEquals(101, courses.get(0).getClassroom());
        assertTrue(courses.get(0).getStudents().contains(students.get(0)));
        assertTrue(students.get(0).getCourses().contains(courses.get(0)));
    }

    @Test
    public void testCreateExistingStudent() {
        String[] parts1 = {"101", "Mathematics", "Jane Doe", "jane.doe@example.com"};
        String[] parts2 = {"101", "Mathematics", "Jane Doe", "jane.doe@example.com"};
        creator1.create(parts1, university, criteriaProcessor);
        creator1.create(parts2, university, criteriaProcessor);
        List<Student> students = university.getStudents();
        assertEquals(1, students.size());
        assertEquals("Jane Doe", students.get(0).getName());
        List<Course> courses = university.getCourses();
        assertEquals(1, courses.size());
        assertEquals("Mathematics", courses.get(0).getName());
        assertTrue(courses.get(0).getStudents().contains(students.get(0)));
        assertTrue(students.get(0).getCourses().contains(courses.get(0)));
    }

}

