package com.university.test.evaluation;

import com.sun.jdi.IntegerValue;

import java.util.List;

public class FinalExam extends Evaluation {
    public FinalExam(String name, String studentName, double grade, String subjectName, List<Integer> grades) {
        super(name, studentName, grade, subjectName, grades);
    }
    public double getGrade(){
        int sum = 0;
        for (int i = 0; i < this.getGrades().size(); i++){
            sum += this.getGrades().get(i);
        }
        return sum;
    }
}
