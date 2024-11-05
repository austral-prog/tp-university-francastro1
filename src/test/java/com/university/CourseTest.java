package com.university;
import com.university.entity.classroom.Course;
import com.university.entity.classroom.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class CourseTest {
    private Course course;
    private Student student1;
    private Student student2;

    @BeforeEach
    public void setUp() {
        course = new Course(101, "Mathematics");
        student1 = new Student("John Doe", "john.doe@example.com");
        student2 = new Student("Jane Smith", "jane.smith@example.com");
    }

    @Test
    public void testCourseCreation() {
        assertEquals(101, course.getClassroom());
        assertEquals("Mathematics", course.getName());
        assertTrue(course.getStudents().isEmpty());
    }

    @Test
    public void testAddStudent() {
        course.addStudent(student1);
        List<Student> students = course.getStudents();
        assertEquals(1, students.size(), "Course should have one student after adding.");
        assertTrue(students.contains(student1), "Course should contain student1.");
    }

    @Test
    public void testAddDuplicateStudent() {
        course.addStudent(student1);
        course.addStudent(student1);
        List<Student> students = course.getStudents();
        assertEquals(1, students.size());
    }

    @Test
    public void testAddMultipleStudents() {
        course.addStudent(student1);
        course.addStudent(student2);
        List<Student> students = course.getStudents();

        assertEquals(2, students.size());
        assertTrue(students.contains(student1));
        assertTrue(students.contains(student2));
    }

    @Test
    public void testSetClassroomInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            course.setClassroom(-1);
        });

        assertEquals("Classroom number cannot be negative", exception.getMessage());
    }

    @Test
    public void testGetId() {
        assertEquals(0, course.getId());
        Course anotherCourse = new Course(202, "Science");
        assertEquals(1, anotherCourse.getId());
    }
}
