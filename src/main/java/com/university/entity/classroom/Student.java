package com.university.entity.classroom;

import com.university.entity.Person;
import com.university.entity.evaluation.Evaluation;

import java.util.*;

public class Student extends Person {
    private HashSet<Course> courses;
    private String email;
    private List<Evaluation> evaluations;

    public Student(String name, String email) {
        super(name);
        this.courses = new HashSet<>();
        this.email = email;
        this.evaluations = new ArrayList<>();
    }

    public HashSet<Course> getCourses() {
        return courses;
    }

    public void addToCourse(Course course){
        if(!courses.contains(course)){
            this.courses.add(course);
        }
    }

    public int getCourseCount() {
        return courses.size();
    }

    public String getEmail() {
        return email;
    }

    public void addEvaluation(Evaluation evaluation) {
        if (!evaluations.contains(evaluation)) {
            evaluations.add(evaluation);
        }
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public List<Double> getGradesForSubjectAndEvaluations(String subject, List<String> evaluationNames) {
        List<Double> grades = new ArrayList<>();
        for (Evaluation eval : evaluations) {
            if (eval.getSubjectName().equals(subject) && evaluationNames.contains(eval.getName())) {
                grades.addAll(eval.getGrades());
            }
        }
        return grades;
    }

    public double calculateAverage(String subject, List<String> evaluationNames) {
        List<Double> grades = getGradesForSubjectAndEvaluations(subject, evaluationNames);
        return grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public double getMaxScore(String subject, List<String> evaluationNames) {
        List<Double> grades = getGradesForSubjectAndEvaluations(subject, evaluationNames);
        return grades.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
    }

    public double getMinScore(String subject, List<String> evaluationNames) {
        List<Double> grades = getGradesForSubjectAndEvaluations(subject, evaluationNames);
        return grades.stream().mapToDouble(Double::doubleValue).min().orElse(0.0);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", email='" + email +
                '}';
    }
}


