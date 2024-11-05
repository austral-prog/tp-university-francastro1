package com.university;

import com.university.entity.classroom.Course;
import com.university.entity.classroom.Student;
import com.university.entity.evaluation.Evaluation;

import java.util.*;

public class University {
    private List<Student> students;
    private List<Course> courses;
    private List<Evaluation> evaluations;

    public University() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.evaluations = new ArrayList<>();
    }

    public void addStudent(Student student) {
    if (!this.students.contains(student)) {
        students.add(student);
    }
    }

    public void addCourse(Course course) {
        if (!this.courses.contains(course)) {
            courses.add(course);
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Evaluation> getEvaluations() {return evaluations;}

    public Map<String, Integer> getStudentCourseCounts() {
        Map<String, Integer> studentCounts = new HashMap<>();
        for (Student student : students) {
            studentCounts.put(student.getName(), student.getCourseCount());
        }
        return studentCounts;
    }
}
