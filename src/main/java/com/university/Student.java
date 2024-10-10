package com.university;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{
    private List<Course> courses;
    private String email;
    private int courseCount;

    public Student(String name, int courseCount, String email) {
        super(name);
        this.courses = new ArrayList<>();
        this.email = email;
        this.courseCount = courseCount;
    }

    public List<Course> getCourses() {
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


