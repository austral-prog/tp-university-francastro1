package com.university;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private List<Student> students;
    private Teacher teacher;
    private int classroom;

    public Course(int classroom, Teacher teacher) {
        if (classroom < 0) {
            throw new IllegalArgumentException("Classroom number cannot be negative");
        }
        this.classroom = classroom;
        this.students = new ArrayList<>();
        this.teacher = teacher;
    }
    public void addStudent(Student student) {
        students.add(student);
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}


