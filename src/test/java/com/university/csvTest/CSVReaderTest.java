package com.university.csvTest;

import com.university.FileReader.creator.Creator;
import com.university.FileReader.creator.Creator1;
import com.university.FileReader.creator.Creator2;
import com.university.University;
import com.university.csv.CSVReader;
import com.university.entity.evaluation.Evaluation;
import com.university.entity.evaluation.criteria.CriteriaProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CSVReaderTest {

    private String filePath;

    @BeforeEach
    public void setUp() {
        filePath = "test.csv";
    }
    @Test
    public void testEmptyFile() throws IOException {
        String csvContent = "";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(csvContent);
        }
        University university = new University();
        Creator creator = new Creator1();
        CriteriaProcessor criteriaProcessor = new CriteriaProcessor();
        CSVReader.processCSV(filePath, university, creator, criteriaProcessor);
        List<Evaluation> evaluations = university.getEvaluations();
        assertEquals(0, evaluations.size());
    }

    @Test
    public void testFileNotFound() {
        String invalidFilePath = "invalid.csv";
        University university = new University();
        Creator creator = new Creator2();
        CriteriaProcessor criteriaProcessor = new CriteriaProcessor();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            CSVReader.processCSV(invalidFilePath, university, creator, criteriaProcessor)
        );
        assertEquals("The specified file was not found: " + invalidFilePath, exception.getMessage());
    }
}
