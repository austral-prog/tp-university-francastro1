package com.university.FileReaderTest.fileCreatorTest;

import static org.junit.jupiter.api.Assertions.*;

import com.university.FileReader.creator.Creator1;
import com.university.University;
import com.university.entity.classroom.Course;
import com.university.entity.classroom.Student;
import com.university.entity.evaluation.criteria.CriteriaProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Student student = university.getStudents().getFirst();
        Course course = university.getCourses().getFirst();
        assertEquals("Olivia Red", student.getName());
        assertEquals("Political Science", course.getName());
        assertTrue(student.getCourses().contains(course));
        assertTrue(course.getStudents().contains(student));
    }
}


