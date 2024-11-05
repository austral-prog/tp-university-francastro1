package com.university.Creator;


import com.university.University;
import com.university.entity.classroom.Student;
import com.university.entity.evaluation.*;

import java.util.List;

public class EvaluationCreator {
    private List<Evaluation> evaluations;

    public EvaluationCreator(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public Evaluation getOrCreateEvaluation(String subjectName, String evaluationName, String studentName, String evaluationType, double grade, University university) {
        Evaluation evaluation = findEvaluation(subjectName, evaluationName, studentName, evaluationType);

        Student student = findStudentByName(studentName, university);
        if (student == null) {
            throw new IllegalArgumentException("Student not found in university: " + studentName);
        }

        if (evaluation == null) {
            evaluation = createEvaluation(subjectName, evaluationName, studentName, evaluationType);
            evaluations.add(evaluation);
            student.addEvaluation(evaluation);
        } else if (!student.getEvaluations().contains(evaluation)) {
            student.addEvaluation(evaluation);
        }

        evaluation.addGrades(grade);
        return evaluation;
    }

    private Evaluation findEvaluation (String subjectName, String evaluationName, String studentName, String
            evaluationType){
        for (Evaluation e : evaluations) {
            if (e.getSubjectName().equals(subjectName) &&
                    e.getName().equals(evaluationName) &&
                    e.getStudentName().equals(studentName) &&
                    e.getEvaluationType().equals(evaluationType)) {
                return e;
            }
        }
        return null;
    }
    public static Evaluation createEvaluation(String subjectName, String evaluationName, String studentName, String evaluationType) {
        switch (evaluationType) {
            case "WRITTEN_EXAM":
                return new WrittenExam(evaluationName, studentName, subjectName, evaluationType);
            case "PRACTICAL_WORK":
                return new PracticalWork(evaluationName, studentName, subjectName, evaluationType);
            case "ORAL_EXAM":
                return new OralExam(evaluationName, studentName, subjectName, evaluationType);
            case "FINAL_PRACTICAL_WORK":
                return new FinalExam(evaluationName, studentName, subjectName, evaluationType);
            default:
                throw new IllegalArgumentException("Unknown evaluation type: " + evaluationType);
        }
    }

    private Student findStudentByName(String studentName, University university) {
        for (Student student : university.getStudents()) {
            if (student.getName().equals(studentName)) {
                return student;
            }
        }
        return null;
    }
}

