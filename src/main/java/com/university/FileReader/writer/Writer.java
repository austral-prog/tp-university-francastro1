package com.university.FileReader.writer;

import com.university.University;
import com.university.entity.evaluation.criteria.CriteriaProcessor;

import java.io.BufferedWriter;
import java.io.IOException;

public interface Writer {
    void write(University university, CriteriaProcessor criteriaProcessor, BufferedWriter writer) throws IOException;
}
