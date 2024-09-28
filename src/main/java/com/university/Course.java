package com.university;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private List<Student> students;
    private int classroom;
    public Course(int classroom) {
        this.classroom = classroom;
        students = new ArrayList<Student>();
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
        this.classroom = classroom;
    }
}
