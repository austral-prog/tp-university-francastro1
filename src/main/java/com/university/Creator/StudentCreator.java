package com.university.Creator;

import com.university.University;
import com.university.entity.classroom.Student;

import java.util.List;

public class StudentCreator implements EntityCreator<Student>{

    private List<Student> students;

    public StudentCreator(List<Student> students){
        this.students = students;
    }

    public Student getOrCreate(String parts, List<Student> students, University university) {
        String[] params = parts.split(",");
        String studentName = params[2].trim();
        String email = params[3].trim();
        Student student = findStudentByName(studentName, students);
        if (student == null) {
            student = new Student(studentName, email);
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

