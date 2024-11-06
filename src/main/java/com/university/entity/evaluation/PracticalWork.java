package com.university.entity.evaluation;

public class PracticalWork extends Evaluation{

    public PracticalWork(String name, String studentName, String subjectName, String evaluationType) {
        super(name, studentName, subjectName, evaluationType);
    }

    @Override
    public double getGrade() {
        return getGrades().getLast();
    }
}
