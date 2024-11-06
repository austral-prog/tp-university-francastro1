package com.university.FileReader.creator;

import com.university.Creator.EvaluationCreator;
import com.university.University;
import com.university.entity.evaluation.criteria.CriteriaProcessor;
import com.university.entity.evaluation.Evaluation;

public class Creator2 implements Creator {
    @Override
    public void create(String parts, University university, CriteriaProcessor criteriaProcessor) {
        EvaluationCreator evaluationCreator = new EvaluationCreator(university.getEvaluations());
        Evaluation evaluation = evaluationCreator.getOrCreate(parts, university.getEvaluations(), university);
        university.addEvaluation(evaluation);
    }
}
