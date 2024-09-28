package com.university;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class CourseTest {

    @Test
    public void testAddStudentToCourse() {
        Course course = new Course(101);
        Student student1 = new Student("Alice Azure", 3, "alice.azure@email.com");
        Student student2 = new Student("Bob Brown", 2, "bob.brown@email.com");
        course.addStudent(student1);
        course.addStudent(student2);
        List<Student> students = course.getStudents();
        assertEquals(2, students.size());
        assertEquals("Alice Azure", students.get(0).getName());
        assertEquals("Bob Brown", students.get(1).getName());
    }

    @Test
    public void testCourseClassroomAssignment() {
        Course course = new Course(578);
        assertEquals(578, course.getClassroom());
        course.setClassroom(331);
        assertEquals(331, course.getClassroom());
    }
}
