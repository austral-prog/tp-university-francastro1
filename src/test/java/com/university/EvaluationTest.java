package com.university;

import com.university.entity.evaluation.FinalExam;
import com.university.entity.evaluation.OralExam;
import com.university.entity.evaluation.PracticalWork;
import com.university.entity.evaluation.WrittenExam;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class EvaluationTest {

    @Test
    public void testFinalExamGrade() {
        FinalExam finalExam = new FinalExam("Examen Final", "Mona Azure", "Physics", "FINAL_EXAM");
        finalExam.addGrades(1.0);
        finalExam.addGrades(9.0);
        finalExam.addGrades(6.0);
        double expectedGrade = 1.0 + 9.0 + 6.0;
        assertEquals(expectedGrade, finalExam.getGrade());
    }

    @Test
    public void testOralExamGrade() {
        OralExam oralExam = new OralExam("Primer Parcial", "Paul Pink", "Sociology", "ORAL_EXAM");
        oralExam.addGrades(3.0);
        double expectedGrade = 3.0;
        assertEquals(expectedGrade, oralExam.getGrade());
    }

    @Test
    public void testPracticalWorkGrade() {
        PracticalWork practicalWork = new PracticalWork("TP Final", "Hank Green", "Computer Science", "FINAL_PRACTICAL_WORK");
        practicalWork.addGrades(5.0);
        practicalWork.addGrades(7.0);
        double expectedGrade = 7.0;
        assertEquals(expectedGrade, practicalWork.getGrade());
    }

    @Test
    public void testWrittenExamGrade() {
        WrittenExam writtenExam = new WrittenExam("Segundo Parcial", "Paul Beige", "English", "WRITTEN_EXAM");
        writtenExam.addGrades(7.0);
        writtenExam.addGrades(0.0);
        writtenExam.addGrades(6.0);
        double expectedGrade = (7.0 + 0.0 + 6.0) / 3.0;
        assertEquals(expectedGrade, writtenExam.getGrade());
    }
}
