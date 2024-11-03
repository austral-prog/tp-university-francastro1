package com.university.Creator;

import com.university.entity.classroom.Course;

import java.util.List;

public class CourseCreator {
    private List<Course> courses;

    public CourseCreator(List<Course> courses) {
        this.courses = courses;
    }

    public Course getOrCreateCourse(int classroom, String subject) {
        Course course = findCourseBySubject(subject);
        if (course == null) {
            course = new Course(classroom, subject);
            courses.add(course);
        }
        return course;
    }

    private Course findCourseBySubject(String subject) {
        for (Course course : courses) {
            if (course.getName().equals(subject)) {
                return course;
            }
        }
        return null;
    }
}

