package com.university;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EvaluationTest {

    @Test
    public void testEvaluationCreation() {
        Evaluation evaluation = new Evaluation("Final Exam", "Jane Doe", 8.0, "Math");

        assertEquals("Final Exam", evaluation.getName());
        assertEquals("Jane Doe", evaluation.getStudentName());
        assertEquals(8.0, evaluation.getGrade());
        assertEquals("Math", evaluation.getSubjectName());
    }

    @Test
    public void testAddExercise() {
        Evaluation evaluation = new Evaluation("Final Exam", "Jane Doe", 8.0, "Math");
        Exercise exercise = new Exercise("Exercise 1");
        evaluation.addExcercise(exercise);

        assertEquals(1, evaluation.getExcercises().size());
        assertEquals(exercise, evaluation.getExcercises().get(0));
    }

    @Test
    public void testInvalidGrade() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Evaluation("Final Exam", "Jane Doe", 11.0, "Math");
        });

        assertEquals("Grade must be between 0 and 10", exception.getMessage());
    }
}
