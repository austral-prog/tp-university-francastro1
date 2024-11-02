package com.university.classroom;

import com.university.entity.Student;
import com.university.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private List<Student> students;
    private String subject;
    private int classroom;

    public Course(int classroom, String subject) {
        if (classroom < 0) {
            throw new IllegalArgumentException("Classroom number cannot be negative");
        }
        this.classroom = classroom;
        this.students = new ArrayList<>();
        this.subject = subject;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        if (classroom < 0) {
            throw new IllegalArgumentException("Classroom number cannot be negative");
        }
        this.classroom = classroom;
    }

    public String getSubject() {
        return subject;
    }
}

