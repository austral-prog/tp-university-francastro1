package com.university.FileReader.creator;

import com.university.University;
import com.university.entity.evaluation.criteria.CriteriaProcessor;
import com.university.entity.evaluation.criteria.Criterion;

import java.util.Arrays;
import java.util.List;

public class Creator3 implements Creator {
    @Override
    public void create(String[] parts, University university, CriteriaProcessor criteriaProcessor) {
        String subjectName = parts[0];
        String criteriaType = parts[1];
        double criteriaValue = Double.parseDouble(parts[2]);
        String evaluationName = parts[3];
        String[] evaluationNames = Arrays.copyOfRange(parts, 3, parts.length);
        Criterion criterion = new Criterion(subjectName, criteriaType, criteriaValue, List.of(evaluationNames));
        criteriaProcessor.addCriteria(criterion);
    }
}
