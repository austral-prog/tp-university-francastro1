package com.university.test.evaluation;

import com.university.Entity;
import com.university.test.Exercise;

import java.util.ArrayList;
import java.util.List;

public abstract class Evaluation implements Entity {

    private String name;
    private int id;
    private String studentName;
    private double grade;
    private String subjectName;
    private List<Exercise> exercises;
    private List<Integer> grades;

    public Evaluation(String name, String studentName, double grade, String subjectName, List<Integer> grades){

        if (grade < 0 || grade > 10) {
            throw new IllegalArgumentException("Grade must be between 0 and 10");
        }
        this.name = name;
        this.studentName = studentName;
        this.grade = grade;
        this.subjectName = subjectName;
        this.exercises = new ArrayList<>();
        this.grades = grades;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public abstract double getGrade();

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

    public List<Integer> getGrades() {
        return this.grades;
    }
}
