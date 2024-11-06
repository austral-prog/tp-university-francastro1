package com.university.FileReaderTest.fileCreatorTest;

import com.university.FileReader.creator.Creator2;
import com.university.University;
import com.university.entity.classroom.Student;
import com.university.entity.evaluation.Evaluation;
import com.university.entity.evaluation.criteria.CriteriaProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Creator2Test {

    private University university;
    private Creator2 creator2;
    private CriteriaProcessor criteriaProcessor;

    @BeforeEach
    void setUp() {
        university = new University();
        creator2 = new Creator2();
        criteriaProcessor = new CriteriaProcessor();
    }

    @Test
    void testCreate() {
        Student student = new Student("Paul Beige", "paulbaige@gmail.com");
        university.addStudent(student);
        String parts = "Paul Beige,English,WRITTEN_EXAM,Segundo Parcial,Ej2,7";
        creator2.create(parts, university, criteriaProcessor);
        Evaluation evaluation = university.getEvaluations().getFirst();
        assertNotNull(evaluation);
        assertEquals("Paul Beige", evaluation.getStudentName());
        assertEquals("English", evaluation.getSubjectName());
        assertEquals(7, evaluation.getGrade());
        assertEquals("WRITTEN_EXAM", evaluation.getEvaluationType());
        assertEquals("Segundo Parcial",evaluation.getName());
    }
}

