package com.university.FileReaderTest.fileWriterTest;

import com.university.FileReader.writer.Writer2;
import com.university.University;
import com.university.entity.evaluation.FinalExam;
import com.university.entity.evaluation.WrittenExam;
import com.university.entity.evaluation.criteria.CriteriaProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

class Writer2Test {

    private University university;
    private CriteriaProcessor criteriaProcessor;
    private Writer2 writer2;

    @BeforeEach
    void setUp() {
        university = new University();
        criteriaProcessor = new CriteriaProcessor();
        writer2 = new Writer2();
    }

    @Test
    void testWrite() throws IOException {

        FinalExam finalExam = new  FinalExam("Final", "John Doe", "Math", "FinalExam");
        finalExam.addGrades(9);
        WrittenExam writtenExam = new  WrittenExam("Primer Parcial", "Jane Doe", "History", "WrittenExam");
        writtenExam.addGrades(6);
        university.addEvaluation(finalExam);
        university.addEvaluation(writtenExam);
        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        writer2.write(university, criteriaProcessor, bufferedWriter);
        bufferedWriter.flush();
        String expectedOutput =
                "Subject_Name,Evaluation_Name,Student_Name,Grade\n" +
                        "History,Primer Parcial,Jane Doe,6.0\n" +
                        "Math,Final,John Doe,9.0";
        String normalizedExpectedOutput = expectedOutput.replaceAll("\\s+", "").replace("\r\n", "\n").replace("\r", "\n");
        String normalizedActualOutput = stringWriter.toString().replaceAll("\\s+", "").replace("\r\n", "\n").replace("\r", "\n");

        assertEquals(normalizedExpectedOutput, normalizedActualOutput);

    }
}

