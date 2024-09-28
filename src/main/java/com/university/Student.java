package com.university;

public class Student {
    private String name;
    private int courseCount;
    private String email;

    public Student(String name, int courseCount, String email) {
        this.name = name;
        this.courseCount = courseCount;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public String getEmail() {
        return email;
    }
}


