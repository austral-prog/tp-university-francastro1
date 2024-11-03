package com.university.csv;

import com.university.University;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

import com.university.entity.evaluation.Evaluation;
import com.university.entity.evaluation.Criterion;

import java.io.*;
import java.util.*;

public class CSVWriter {

    public static void writeCSV1(String filePath, University university) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Student_Name,Course_Count\n");
            Map<String, Integer> studentCounts = university.getStudentCourseCounts();
            List<Map.Entry<String, Integer>> sortedEntries = Sorter.sortByName(studentCounts);
            for (Map.Entry<String, Integer> entry : sortedEntries) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeResults(String filePath, University university) {
        List<Evaluation> evaluations = university.getEvaluations();
        Collections.sort(evaluations,
                Comparator.comparing(Evaluation::getSubjectName)
                        .thenComparing(Evaluation::getName)
                        .thenComparing(Evaluation::getStudentName));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Subject_Name,Evaluation_Name,Student_Name,Grade");
            writer.newLine();
            for (Evaluation eval : evaluations) {
                writer.write(eval.getSubjectName() + "," +
                        eval.getName() + "," +
                        eval.getStudentName() + "," +
                        eval.getGrade());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateCSV(String filePath, University university, CriteriaProcessor criteriaProcessor) throws IOException {
        List<String> results = criteriaProcessor.evaluateStudents(university);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Student,Subject,Status\n");
            for (String result : results) {
                writer.write(result);
                writer.write("\n");
            }
        }
    }
}
