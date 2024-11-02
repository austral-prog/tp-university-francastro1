package com.university;
import static org.junit.jupiter.api.Assertions.*;

import com.university.classroom.Course;
import com.university.entity.Student;
import com.university.entity.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourseTest {

    private Course course;
    private Teacher teacher;

    @BeforeEach
    public void setUp() {
        course = new Course(101, "History");
    }

    @Test
    public void testCourseCreation() {
        assertEquals(101, course.getClassroom());
        assertEquals("History", course.getSubject());
        assertTrue(course.getStudents().isEmpty());
    }

    @Test
    public void testAddStudent() {
        Student student = new Student("Jane Doe", "jane@example.com");
        course.addStudent(student);

        assertEquals(1, course.getStudents().size());
        assertEquals(student, course.getStudents().get(0));
    }

    @Test
    public void testSetClassroom() {
        course.setClassroom(202);
        assertEquals(202, course.getClassroom());
    }

    @Test
    public void testInvalidClassroom() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            course.setClassroom(-1);
        });

        assertEquals("Classroom number cannot be negative", exception.getMessage());
    }
}
