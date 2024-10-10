package com.university;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TeacherTest {

    @Test
    public void testTeacherCreation() {
        Teacher teacher = new Teacher("John Doe", "Math", 1234);

        assertEquals("John Doe", teacher.getName());
        assertEquals("Math", teacher.getSubject());
        assertEquals(1234, teacher.getId());
    }
}


