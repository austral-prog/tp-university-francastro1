package com.university;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TeacherTest {

    @Test
    public void testTeacherInitialization() {
        Teacher teacher = new Teacher("Prof. Sam", "Political Science", 101);
        assertEquals("Prof. Sam", teacher.getName());
        assertEquals("Political Science", teacher.getSubject());
        assertEquals(101, teacher.getId());
    }
}

