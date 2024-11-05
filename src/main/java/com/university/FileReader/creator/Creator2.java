package com.university.FileReader.creator;

import com.university.Creator.EvaluationCreator;
import com.university.University;
import com.university.entity.evaluation.criteria.CriteriaProcessor;
import com.university.entity.evaluation.Evaluation;

public class Creator2 implements Creator {
    @Override
    public void create(String[] parts, University university, CriteriaProcessor criteriaProcessor) {
        String studentName = parts[0].trim();
        String subjectName = parts[1].trim();
        String evaluationType = parts[2].trim();
        String evaluationName = parts[3].trim();
        double grade = Double.parseDouble(parts[5].trim());
        EvaluationCreator evaluationCreator = new EvaluationCreator(university.getEvaluations());
        Evaluation evaluation = evaluationCreator.getOrCreateEvaluation(subjectName, evaluationName, studentName, evaluationType, grade, university);

    }
}