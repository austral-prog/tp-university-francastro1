package com.university.FileReaderTest.fileWriterTest;

import com.university.FileReader.writer.Writer3;
import com.university.University;
import com.university.entity.classroom.Course;
import com.university.entity.classroom.Student;
import com.university.entity.evaluation.Evaluation;
import com.university.entity.evaluation.FinalExam;
import com.university.entity.evaluation.criteria.CriteriaProcessor;
import com.university.entity.evaluation.criteria.Criterion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Writer3Test {

    private University university;
    private CriteriaProcessor criteriaProcessor;
    private Writer3 writer3;

    @BeforeEach
    void setUp() {
        university = new University();
        Student student = new Student("John Doe","johndoe@gmail.com");
        Student student1 = new Student("Jane Smith","janesmith@gmail.com");
        university.addStudent(student);
        university.addStudent(student1);
        Course math = new Course(505,"Math");
        Course history = new Course(132,"History");
        university.addCourse(math);
        university.addCourse(history);
        Evaluation mathExam = new FinalExam("Final", "John Doe", "Math", "FINAL_EXAM");
        mathExam.addGrades(9.0);
        student.addEvaluation(mathExam);
        Evaluation historyExam = new FinalExam("Primer Parcial", "Jane Smith", "History", "FINAL_EXAM");
        historyExam.addGrades(6.0);
        student1.addEvaluation(historyExam);
        criteriaProcessor = new CriteriaProcessor();
        String evaluationName1 = "Examen Final";
        String evaluationName2 = "Examen Final";
        List<String> evaluationNames1 = new ArrayList<>();
        List<String> evaluationNames2 = new ArrayList<>();
        evaluationNames1.add(evaluationName1);
        evaluationNames2.add(evaluationName2);
        criteriaProcessor.addCriteria(new Criterion("Math", "MAX_ABOVE_VALUE",4.0, evaluationNames1));
        criteriaProcessor.addCriteria(new Criterion("History", "MAX_ABOVE_VALUE",4.0, evaluationNames2));
        writer3 = new Writer3();
    }

    @Test
    void testWrite() throws IOException {
        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        writer3.write(university, criteriaProcessor, bufferedWriter);
        bufferedWriter.flush();
        String expectedOutput =
                "Student,Subject,Status\n" +
                        "John Doe,Math,FAILED\n" +
                        "Jane Smith,History,FAILED\n";
        assertEquals(expectedOutput, stringWriter.toString(), "La salida generada debe coincidir con el formato esperado.");
    }
}

