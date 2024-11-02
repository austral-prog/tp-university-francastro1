package com.university.Creator;

import com.university.entity.Student;
import com.university.test.evaluation.*;

import java.util.List;

public class EvaluationCreator {
    private List<Evaluation> evaluations;

    public EvaluationCreator(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public Evaluation getOrCreateEvaluation(String subjectName, String evaluationName, String studentName, String evaluationType, double grade) {
        boolean exists = findEvaluation(subjectName, evaluationName, studentName, evaluationType);
        if (exists == false) {
            switch (evaluationType) {
                case "WRITTEN_EXAM":
                    Evaluation evaluation = new WrittenExam(evaluationName, studentName, subjectName, evaluationType);
                    evaluations.add(evaluation);
                    break;
                case "PRACTICAL_WORK":
                    Evaluation evaluation1 = new PracticalWork(evaluationName, studentName, subjectName, evaluationType);
                    evaluations.add(evaluation1);
                    break;
                case "ORAL_EXAM":
                    Evaluation evaluation2 = new OralExam(evaluationName, studentName, subjectName, evaluationType);
                    evaluations.add(evaluation2);
                    break;
                case "FINAL_PRACTICAL_WORK":
                    Evaluation evaluation3 = new FinalExam(evaluationName, studentName, subjectName, evaluationType);
                    evaluations.add(evaluation3);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown evaluation type: " + evaluationType);
            }

        }

        evaluation.addGrades(grade);
        return evaluation;
    }

    private boolean findEvaluation(String subjectName, String evaluationName, String studentName, String evaluationType) {
        for (Evaluation e : evaluations) {
            if (evaluations.contains(e)) {
                return e;
            }
        }
        return false;
    }
}
