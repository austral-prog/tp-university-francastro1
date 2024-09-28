package com.university;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    public void testStudentInitialization() {
        Student student = new Student("Alice Azure", 3, "alice.azure@email.com");
        assertEquals("Alice Azure", student.getName());
        assertEquals(3, student.getCourseCount());
        assertEquals("alice.azure@email.com", student.getEmail());
    }
}