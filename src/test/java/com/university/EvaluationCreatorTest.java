package com.university;
import static org.junit.jupiter.api.Assertions.*;

import com.university.Creator.EvaluationCreator;
import com.university.entity.classroom.Student;
import com.university.entity.evaluation.Evaluation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

