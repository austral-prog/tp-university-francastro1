package com.university;

import com.university.classroom.Course;
import com.university.entity.Student;

import java.util.*;

public class University {
    private List<Student> students;
    private List<Course> courses;

    public University() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Map<String, Integer> getStudentCourseCounts() {
        Map<String, Integer> studentCounts = new HashMap<>();
        for (Student student : students) {
            studentCounts.put(student.getName(), student.getCourseCount());
        }
        return studentCounts;
    }
}
