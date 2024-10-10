package com.university;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExerciseTest {

    @Test
    public void testExerciseCreation() {
        Exercise exercise = new Exercise("Exercise 1");

        assertEquals("Exercise 1", exercise.getName());
    }
}

