package com.university.test.evaluation;

public class WrittenExam extends Evaluation{
    public WrittenExam(String name, String studentName,String subjectName, String evaluationType) {
        super(name, studentName, subjectName,evaluationType);
    }

    public double getGrade(){
        int suma = 0;
        for (double grade : getGrades()){
            suma += grade;
        }
        return suma/(getGrades().size());
    }
}
