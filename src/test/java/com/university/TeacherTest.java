package com.university;

import com.university.entity.Teacher;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TeacherTest {

    @Test
    public void testTeacherCreation() {
        Teacher teacher = new Teacher("John Doe", "Math", 1234);

        assertEquals("John Doe", teacher.getName());
        assertEquals("Math", teacher.getSubject());
        assertEquals(1234, teacher.getId());
    }
}


