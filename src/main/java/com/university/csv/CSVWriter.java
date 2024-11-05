package com.university.csv;

import com.university.University;

import java.io.BufferedWriter;
import com.university.FileReader.writer.Writer;
import com.university.entity.evaluation.criteria.CriteriaProcessor;

import java.io.*;

public class CSVWriter {

    public static void writeCSV(String filePath, University university, CriteriaProcessor criteriaProcessor, Writer fileWriter) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            fileWriter.write(university, criteriaProcessor, writer);
        }
    }
}