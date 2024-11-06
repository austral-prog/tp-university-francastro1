package com.university.FileReader.creator;

import com.university.University;
import com.university.entity.evaluation.criteria.CriteriaProcessor;
import com.university.entity.evaluation.criteria.Criterion;

import java.util.Arrays;
import java.util.List;

public class Creator3 implements Creator {
    @Override
    public void create(String parts, University university, CriteriaProcessor criteriaProcessor) {
        String[] params = parts.split(",");
        String subjectName = params[0];
        String criteriaType = params[1];
        double criteriaValue = Double.parseDouble(params[2]);
        String[] evaluationNames = Arrays.copyOfRange(params, 3, params.length);
        Criterion criterion = new Criterion(subjectName, criteriaType, criteriaValue, List.of(evaluationNames));
        criteriaProcessor.addCriteria(criterion);
    }
}
