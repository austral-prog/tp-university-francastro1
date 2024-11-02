package com.university.test.evaluation;

import com.university.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class Evaluation implements Entity {

    private int id = 0;
    private String name;
    private String studentName;
    private String subjectName;
    private String evaluationType;
    private List<Double> grades;

    public Evaluation(String name, String studentName, String subjectName, String evaluationType){
        this.id += 1;
        this.name = name;
        this.studentName = studentName;
        this.subjectName = subjectName;
        this.evaluationType = evaluationType;
        this.grades = new ArrayList<>();
    }
    public int getId(){return this.id;}

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

    public String getSubjectName() {
        return subjectName;
    }

    public List<Double> getGrades() {
        return this.grades;
    }

    public void addGrades(double grade) {
        this.grades.add(grade);
    }
}
