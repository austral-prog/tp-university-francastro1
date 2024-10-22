package com.university.test;

import com.university.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class Evaluation implements Entity {

    private String name;
    private String studentName;
    private double grade;
    private String subjectName;
    private List<Exercise> exercises;

    public Evaluation(String name, String studentName, double grade, String subjectName){

        if (grade < 0 || grade > 10) {
            throw new IllegalArgumentException("Grade must be between 0 and 10");
        }

        this.name = name;
        this.studentName = studentName;
        this.grade = grade;
        this.subjectName = subjectName;
        this.exercises = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public double getGrade() {
        return grade;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Exercise> getExcercises() {
        return exercises;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void addExcercise(Exercise excercise){
        this.exercises.add(excercise);
    }
}
