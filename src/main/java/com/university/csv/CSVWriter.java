package com.university.csv;

import com.university.University;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import com.university.University;
import com.university.classroom.Course;
import com.university.entity.Student;
import com.university.test.evaluation.Evaluation;

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
}
/*
    private static void writeCSV2(String filePath, Map<String, List<Evaluation>> evaluations) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Subject_Name,Evaluation_Name,Student_Name,Grade\n");

            List<Evaluation> allEvaluations = new ArrayList<>();
            for (List<Evaluation> evalList : evaluations.values()) {
                allEvaluations.addAll(evalList);
            }

            allEvaluations.sort(Comparator.comparing(Evaluation::getSubjectName));

            for (Evaluation evaluation : allEvaluations) {
                writer.write(evaluation.getSubjectName() + "," +
                        evaluation.getName() + "," +
                        evaluation.getStudentName() + "," +
                        evaluation.getGrade() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/