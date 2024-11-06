package com.university.CreatorTest;
import static org.junit.jupiter.api.Assertions.*;

import com.university.Creator.EvaluationCreator;
import com.university.University;
import com.university.entity.classroom.Student;
import com.university.entity.evaluation.Evaluation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
/*
public class EvaluationCreatorTest {
    private List<Evaluation> evaluations;
    private University university;
    private EvaluationCreator evaluationCreator;

    @BeforeEach
    public void setUp() {
        evaluations = new ArrayList<>();
        university = new University();
        evaluationCreator = new EvaluationCreator(evaluations);
    }

    @Test
    public void testCreateEvaluation() {
        String subjectName = "Biology";
        String evaluationName = "FinalExam";
        String studentName = "David";
        String evaluationType = "FINAL_PRACTICAL_WORK";
        Evaluation evaluation = EvaluationCreator.createEvaluation(subjectName, evaluationName, studentName, evaluationType);
        assertEquals("FINAL_PRACTICAL_WORK", evaluation.getEvaluationType());
        assertEquals(subjectName, evaluation.getSubjectName());
        assertEquals(evaluationName, evaluation.getName());
        assertEquals(studentName, evaluation.getStudentName());
    }
}
*/

class EvaluationCreatorTest {
    private List<Evaluation> evaluations;
    private EvaluationCreator evaluationCreator;
    private University university;

    @BeforeEach
    void setUp() {
        evaluations = new ArrayList<>();
        evaluationCreator = new EvaluationCreator(evaluations);
        university = new University();
        Student student = new Student("John Doe","john@doe.com");
        university.addStudent(student);
    }

    @Test
    void testNewEvaluation() {
        String parts = "John Doe, Programacion, WRITTEN_EXAM, Parcial, , 8.5";
        Evaluation evaluation = evaluationCreator.getOrCreate(parts, evaluations, university);
        assertEquals(1, evaluations.size());
        assertEquals("Programacion", evaluation.getSubjectName());
        assertEquals("Parcial", evaluation.getName());
        assertEquals("John Doe", evaluation.getStudentName());
        assertEquals("WRITTEN_EXAM", evaluation.getEvaluationType());

        Student student = university.getStudents().get(0);
        assertTrue(student.getEvaluations().contains(evaluation));
    }

    @Test
    void testExistingEvaluation() {
        String parts = "John Doe, Programacion, WRITTEN_EXAM, Parcial, , 8.0";
        Evaluation initialEvaluation = evaluationCreator.getOrCreate(parts, evaluations, university);
        String newParts = "John Doe, Programacion, WRITTEN_EXAM, Parcial, , 7.0";
        Evaluation fetchedEvaluation = evaluationCreator.getOrCreate(newParts, evaluations, university);
        assertEquals(1, evaluations.size());
        assertEquals(initialEvaluation, fetchedEvaluation);
        assertEquals("Programacion", fetchedEvaluation.getSubjectName());
        assertEquals("Parcial", fetchedEvaluation.getName());
        assertEquals("John Doe", fetchedEvaluation.getStudentName());
    }

    @Test
    void testStudentNotFound() {
        String parts = "Jane Doe, Algebra, ORAL_EXAM, Examen Oral, , 9.0";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            evaluationCreator.getOrCreate(parts, evaluations, university);
        });
        assertEquals("Student not found in university: Jane Doe", exception.getMessage());
    }

    @Test
    void testInvalidType() {
        String invalidParts = "John Doe, Algebra, UNKNOWN_TYPE, Parcial, , 6.0";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            evaluationCreator.getOrCreate(invalidParts, evaluations, university);
        });
        assertEquals("Unknown evaluation type: UNKNOWN_TYPE", exception.getMessage());
    }
}

