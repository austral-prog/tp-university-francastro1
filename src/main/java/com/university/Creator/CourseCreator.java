package com.university.Creator;

import com.university.University;
import com.university.entity.classroom.Course;

import java.util.List;

public class CourseCreator implements  EntityCreator<Course>{
    private List<Course> courses;

    public CourseCreator(List<Course> courses) {
        this.courses = courses;
    }

    public Course getOrCreate(String parts, List<Course> courses, University university) {
        String[] params = parts.split(",");
        int classroom = Integer.parseInt(params[0]);
        String subject = params[1];
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

