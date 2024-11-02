package com.university.Creator;

import com.university.University;
import com.university.entity.Student;

import java.util.List;

public class StudentCreator {

    public Student getOrCreateStudent(String name, String email, List<Student> students) {
        Student student = findStudentByName(name, students);
        if (student == null) {
            student = new Student(name, email);
            students.add(student);
        }
        return student;
    }

    private Student findStudentByName(String name, List<Student> students) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }
}

