package com.university;

import com.university.Creator.CourseCreator;
import com.university.entity.classroom.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class CourseCreatorTest {
    private CourseCreator courseCreator;
    private List<Course> courses;

    @BeforeEach
    public void setUp() {
        courses = new ArrayList<>();
        courseCreator = new CourseCreator(courses);
    }

    @Test
    public void testGetOrCreateCourse_NewCourse() {
        Course course = courseCreator.getOrCreateCourse(101, "Mathematics");
        assertEquals(101, course.getClassroom());
        assertEquals("Mathematics", course.getName());
        assertEquals(1, courses.size());
    }

    @Test
    public void testGetOrCreateCourse_ExistingCourse() {
        Course existingCourse = new Course(102, "Physics");
        courses.add(existingCourse);
        Course course = courseCreator.getOrCreateCourse(103, "Physics");
        assertEquals(1, courses.size());
    }
}

