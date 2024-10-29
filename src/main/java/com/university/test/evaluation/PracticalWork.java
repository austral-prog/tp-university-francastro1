package com.university.test.evaluation;

public class PracticalWork extends Evaluation{
    public PracticalWork(String name, String studentName, double grade, String subjectName) {
        super(name, studentName, grade, subjectName, grades);
    }

    @Override
    public double getGrade() {
        return 0;
    }
}
