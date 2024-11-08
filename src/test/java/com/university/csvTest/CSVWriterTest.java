package com.university.csvTest;

import com.university.FileReader.writer.Writer1;
import com.university.University;
import com.university.csv.CSVWriter;
import com.university.entity.evaluation.OralExam;
import com.university.entity.evaluation.WrittenExam;
import com.university.entity.evaluation.criteria.CriteriaProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CSVWriterTest {

    private String filePath;

    @BeforeEach
    public void setUp() {
        filePath = "output.csv";
    }

    @Test
    public void testWriteCSVHandlesEmptyUniversity() throws IOException {
        University university = new University();
        CriteriaProcessor criteriaProcessor = new CriteriaProcessor();
        CSVWriter.writeCSV(filePath, university, criteriaProcessor, new Writer1());
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        assertEquals(1, lines.size());
        Files.delete(Paths.get(filePath));
    }

    @Test
    public void testWriteCSVHandlesIOException() {
        String invalidFilePath = "/invalid_directory/output.csv";
        University university = new University();
        CriteriaProcessor criteriaProcessor = new CriteriaProcessor();
        try {
            CSVWriter.writeCSV(invalidFilePath, university, criteriaProcessor, new Writer1());
            fail("Expected IOException was not thrown");
        } catch (IOException e) {
            assertEquals(e.getMessage(),"\\invalid_directory\\output.csv (El sistema no puede encontrar la ruta especificada)");
        }
    }
}

