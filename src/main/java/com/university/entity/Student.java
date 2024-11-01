package com.university.entity;

import com.university.classroom.Course;

import java.util.*;

public class Student extends Person {
    private HashSet<Course> courses;
    private String email;

    public Student(String name, String email) {
        super(name);
        this.courses = new HashSet<>();
        this.email = email;
    }

    public HashSet<Course> getCourses() {
        return courses;
    }

    public void addToCourse(Course course){
        this.courses.add(course);
    }

    public int getCourseCount() {
        return courses.size();
    }

    public String getEmail() {
        return email;
    }

}


