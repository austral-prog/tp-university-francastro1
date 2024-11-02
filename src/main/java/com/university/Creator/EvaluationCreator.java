package com.university.Creator;

import com.university.entity.Student;
import com.university.test.evaluation.*;

import java.util.List;
/*
public class EvaluationCreator {
    private List<Evaluation> evaluations;

    public EvaluationCreator(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public Evaluation getOrCreateEvaluation(String subjectName, String evaluationName, String studentName, String evaluationType, double grade) {
        boolean exists = findEvaluation(subjectName, evaluationName, studentName, evaluationType);
        if (!exists == false) {
            switch (evaluationType) {
                case "WRITTEN_EXAM":
                    Evaluation evaluation = new WrittenExam(evaluationName, studentName, subjectName, evaluationType);
                    evaluations.add(evaluation);
                    return evaluation;
                case "PRACTICAL_WORK":
                    Evaluation evaluation1 = new PracticalWork(evaluationName, studentName, subjectName, evaluationType);
                    evaluations.add(evaluation1);
                    return evaluation1;
                case "ORAL_EXAM":
                    Evaluation evaluation2 = new OralExam(evaluationName, studentName, subjectName, evaluationType);
                    evaluations.add(evaluation2);
                    return evaluation2;
                case "FINAL_PRACTICAL_WORK":
                    Evaluation evaluation3 = new FinalExam(evaluationName, studentName, subjectName, evaluationType);
                    evaluations.add(evaluation3);
                    return evaluation3;
                default:
                    throw new IllegalArgumentException("Unknown evaluation type: " + evaluationType);
            }

        }

        evaluation.addGrades(grade);

    }

    private boolean findEvaluation(String subjectName, String evaluationName, String studentName, String evaluationType) {
        boolean exists = false;
        for (Evaluation e : evaluations) {
            if (e.getSubjectName().equals(subjectName) && e.getName().equals(evaluationName) && e.getStudentName().equals(studentName) && e.getEvaluationType().equals(evaluationType))) {
                exists = true;
                return exists;
            }
        }
        return exists;
    }
}*/

public class EvaluationCreator {
    private List<Evaluation> evaluations;

    public EvaluationCreator(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public Evaluation getOrCreateEvaluation(String subjectName, String evaluationName, String studentName, String evaluationType, double grade) {
        Evaluation evaluation = findEvaluation(subjectName, evaluationName, studentName, evaluationType);

        if (evaluation == null) {
            evaluation = createEvaluation(subjectName, evaluationName, studentName, evaluationType);
            evaluations.add(evaluation);
        }

        evaluation.addGrades(grade);
        return evaluation;
    }

    private Evaluation findEvaluation(String subjectName, String evaluationName, String studentName, String evaluationType) {
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

    private Evaluation createEvaluation(String subjectName, String evaluationName, String studentName, String evaluationType) {
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
}

