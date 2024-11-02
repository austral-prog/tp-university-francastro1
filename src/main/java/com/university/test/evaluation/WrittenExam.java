package com.university.test.evaluation;

public class WrittenExam extends Evaluation{
    public WrittenExam(String name, String studentName,String subjectName, String evaluationType) {
        super(name, studentName, subjectName,evaluationType);
    }

    public double getGrade(){
        double suma = 0;
        for (double grade : getGrades()){
            suma += grade;
        }
        return suma/(getGrades().size());
    }
}
