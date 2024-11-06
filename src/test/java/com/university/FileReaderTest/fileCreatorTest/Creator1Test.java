package com.university.FileReaderTest.fileCreatorTest;

import static org.junit.jupiter.api.Assertions.*;

import com.university.FileReader.creator.Creator1;
import com.university.University;
import com.university.entity.classroom.Course;
import com.university.entity.classroom.Student;
import com.university.entity.evaluation.criteria.CriteriaProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
public class Creator1Test {

    private University university;
    private Creator1 creator;

    @BeforeEach
    public void setUp() {
        university = new University();
        creator = new Creator1();
    }

    @Test
    public void testCreateStudentAndCourse() {
        String studentName = "Alice";
        String email = "alice@example.com";
        String inputData = studentName + ", " + email;
        creator.create(inputData, university, null);
        assertEquals(1, university.getStudents().size());
        Student student = university.getStudents().getFirst();
        assertEquals(studentName, student.getName());
        assertEquals(email, student.getEmail());
        assertEquals(1, university.getCourses().size());
        Course course = university.getCourses().getFirst();
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
        assertEquals(2, university.getStudents().size());
        assertEquals(2, university.getStudents().size());
        Student student1 = university.getStudents().get(0);
        Student student2 = university.getStudents().get(1);
        Course course1 = university.getCourses().get(0);
        Course course2 = university.getCourses().get(1);
        assertTrue(course1.getStudents().contains(student1));
        assertTrue(course2.getStudents().contains(student2));
        assertTrue(student1.getCourses().contains(course1));
        assertTrue(student2.getCourses().contains(course2));
    }
}*/

public class Creator1Test {
    private University university;
    private CriteriaProcessor criteriaProcessor;
    private Creator1 creator1;

    @BeforeEach
    public void setUp() {
        university = new University();
        criteriaProcessor = new CriteriaProcessor();
        creator1 = new Creator1();
    }

    @Test
    public void testCreate() {
        String parts = "578,Political Science,Olivia Red,olivia.red@student.org,Prof. Sam";
        creator1.create(parts, university, criteriaProcessor);
        assertEquals(1, university.getStudents().size());
        assertEquals(1, university.getCourses().size());
        Student student = university.getStudents().get(0);
        Course course = university.getCourses().get(0);
        assertEquals("Olivia Red", student.getName());
        assertEquals("Political Science", course.getName());
        assertTrue(student.getCourses().contains(course));
        assertTrue(course.getStudents().contains(student));
    }
}


