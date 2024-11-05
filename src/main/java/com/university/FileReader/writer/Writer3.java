package com.university.FileReader.writer;

import com.university.University;
import com.university.entity.evaluation.criteria.CriteriaProcessor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class Writer3 implements Writer {
    @Override
    public void write(University university, CriteriaProcessor criteriaProcessor, BufferedWriter writer) throws IOException {
        writer.write("Student,Subject,Status\n");
        List<String> results = criteriaProcessor.evaluateStudents(university);
        for (String result : results) {
            writer.write(result);
            writer.write("\n");
        }
    }
}
