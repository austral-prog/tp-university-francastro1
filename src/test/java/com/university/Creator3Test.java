package com.university;

import com.university.FileReader.creator.Creator;
import com.university.FileReader.creator.Creator3;
import com.university.entity.evaluation.criteria.CriteriaProcessor;
import com.university.entity.evaluation.criteria.Criterion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


public class Creator3Test {

    @Test
    public void testCreate() {
        University university = new University();
        CriteriaProcessor criteriaProcessor = new CriteriaProcessor();
        Creator creator = new Creator3();
        String parts = "Geography, AVERAGE_ABOVE_VALUE, 6.0, TP1";
        creator.create(parts, university, criteriaProcessor);
        List<Criterion> criteriaList = criteriaProcessor.getCriteriaList();
        assertEquals(1, criteriaList.size());
        Criterion criterion = criteriaList.get(0);
        assertEquals("Geography", criterion.getSubjectName());

    }
}

