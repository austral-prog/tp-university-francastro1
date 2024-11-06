package com.university;

import com.university.entity.classroom.Course;
import com.university.entity.classroom.Student;
import com.university.entity.evaluation.Evaluation;
import com.university.entity.evaluation.OralExam;
import com.university.entity.evaluation.WrittenExam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
/*
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
}*/

public class UniversityTest {
    private University university;
    private Student student1;
    private Student student2;
    private Evaluation evaluation1;
    private Evaluation evaluation2;

    @BeforeEach
    void setUp() {
        university = new University();
        student1 = new Student("John","john@gmail.com");
        student2 = new Student("Alice","alice@gmail.com");
        evaluation1 = new WrittenExam("Primer Parcial", "John", "Math", "WRITTEN_EXAM");
        evaluation2 = new OralExam("Segundo Parcial", "Alice", "History", "ORAL_EXAM");
    }

    @Test
    void testAddStudent() {
        university.addStudent(student1);
        university.addStudent(student2);

        List<Student> students = university.getStudents();
        assertEquals(2, students.size());
        assertTrue(students.contains(student1));
        assertTrue(students.contains(student2));
    }

    @Test
    void testAddEvaluation() {
        university.addEvaluation(evaluation1);
        university.addEvaluation(evaluation2);

        List<Evaluation> evaluations = university.getEvaluations();
        assertEquals(2, evaluations.size());
        assertTrue(evaluations.contains(evaluation1));
        assertTrue(evaluations.contains(evaluation2));
    }

    @Test
    void testGetStudentCourseCounts() {
        student1.addToCourse(new Course(505,"Math"));
        student1.addToCourse(new Course(400,"Science"));
        student2.addToCourse(new Course(13,"History"));

        university.addStudent(student1);
        university.addStudent(student2);

        Map<String, Integer> courseCounts = university.getStudentCourseCounts();

        assertEquals(2, courseCounts.get("John"));
        assertEquals(1, courseCounts.get("Alice"));
    }

    @Test
    void testEmptyUniversity() {
        assertTrue(university.getStudents().isEmpty());
        assertTrue(university.getCourses().isEmpty());
        assertTrue(university.getEvaluations().isEmpty());
        assertTrue(university.getStudentCourseCounts().isEmpty());
    }
}

