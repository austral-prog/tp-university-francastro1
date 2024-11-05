package com.university;

import com.university.FileReader.creator.Creator2;
import com.university.entity.evaluation.criteria.CriteriaProcessor;
import com.university.entity.classroom.Course;
import com.university.entity.classroom.Student;
import com.university.entity.evaluation.Evaluation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Creator2Test {
    private Creator2 creator2;
    private University university;
    private CriteriaProcessor criteriaProcessor;

    @BeforeEach
    public void setUp() {
        creator2 = new Creator2();
        university = new University();
        criteriaProcessor = new CriteriaProcessor();
    }

    @Test
    public void testCreateNewEvaluation() {
        String[] parts = {"John Doe", "Mathematics", "WRITTEN_EXAM", "Primer Parcial", "Ej 1", "8.0"};
        Student student = new Student("John Doe", "john.doe@example.com");
        university.getStudents().add(student);
        Course course = new Course(101, "Mathematics");
        university.getCourses().add(course);
        student.addToCourse(course);
        course.addStudent(student);
        creator2.create(parts, university, criteriaProcessor);
        List<Evaluation> evaluations = university.getEvaluations();
        assertEquals(1, evaluations.size());
        Evaluation evaluation = evaluations.get(0);
        assertEquals("Mathematics", evaluation.getSubjectName());
        assertEquals("Primer Parcial", evaluation.getName());
        assertEquals("John Doe", evaluation.getStudentName());
        assertEquals("WRITTEN_EXAM", evaluation.getEvaluationType());
        assertEquals(8.0, evaluation.getGrades().get(0));
        assertTrue(student.getEvaluations().contains(evaluation));
    }

    @Test
    public void testCreate_ExistingEvaluation() {
        String[] parts = {"Jane Doe", "Physics", "WRITTEN_EXAM", "Final Exam", "Ej2", "9.0"};
        Student student = new Student("Jane Doe", "jane.doe@example.com");
        university.getStudents().add(student);
        Course course = new Course(102, "Physics");
        university.getCourses().add(course);
        student.addToCourse(course);
        course.addStudent(student);
        creator2.create(new String[]{"Jane Doe", "Physics", "WRITTEN_EXAM", "Final Exam", "Ej 8", "8.0"}, university, criteriaProcessor);
        String[] parts2 = {"Jane Doe", "Physics", "WRITTEN_EXAM", "Final Exam", "Ej 10", "9.0"};
        creator2.create(parts2, university, criteriaProcessor);
        List<Evaluation> evaluations = university.getEvaluations();
        assertEquals(1, evaluations.size());
        Evaluation evaluation = evaluations.get(0);
        assertEquals(2, evaluation.getGrades().size());
        assertEquals(8.0, evaluation.getGrades().get(0));
        assertEquals(9.0, evaluation.getGrades().get(1));
        assertTrue(student.getEvaluations().contains(evaluation));
    }
}

