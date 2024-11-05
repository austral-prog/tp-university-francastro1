package com.university;
import com.university.Creator.EvaluationCreator;
import com.university.entity.classroom.Student;
import com.university.entity.evaluation.Evaluation;
import com.university.entity.evaluation.WrittenExam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class EvaluationCreatorTest {
    private EvaluationCreator evaluationCreator;
    private List<Evaluation> evaluations;
    private University university;
    private Student student;

    @BeforeEach
    public void setUp() {
        evaluations = new ArrayList<>();
        evaluationCreator = new EvaluationCreator(evaluations);
        university = new University();
        student = new Student("John Doe", "john.doe@example.com");
        university.getStudents().add(student);
    }

    @Test
    public void testGetOrCreateEvaluation_NewEvaluation() {
        Evaluation evaluation = evaluationCreator.getOrCreateEvaluation("Mathematics", "Primer Parcial", "John Doe", "WRITTEN_EXAM", 8.0, university);
        assertEquals("Mathematics", evaluation.getSubjectName());
        assertEquals("Primer Parcial", evaluation.getName());
        assertEquals("John Doe", evaluation.getStudentName());
        assertEquals(1, evaluations.size());
        assertTrue(student.getEvaluations().contains(evaluation));
    }

    @Test
    public void testGetOrCreateEvaluation_ExistingEvaluation() {
        Evaluation existingEvaluation = new WrittenExam("Primer Parcial", "John Doe", "Mathematics", "WRITTEN_EXAM");
        evaluations.add(existingEvaluation);
        Evaluation evaluation = evaluationCreator.getOrCreateEvaluation("Mathematics", "Primer Parcial", "John Doe", "WRITTEN_EXAM", 9.0, university);
        assertEquals(1, evaluations.size());
        assertTrue(student.getEvaluations().contains(evaluation));
    }
}

