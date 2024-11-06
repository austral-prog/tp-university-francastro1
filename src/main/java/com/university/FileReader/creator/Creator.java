package com.university.FileReader.creator;

import com.university.University;
import com.university.entity.evaluation.criteria.CriteriaProcessor;

public interface Creator {
    void create(String parts, University university, CriteriaProcessor criteriaProcessor);
}
