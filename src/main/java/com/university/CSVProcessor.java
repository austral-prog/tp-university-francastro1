package com.university;

import java.io.*;
import java.util.*;

public class CSVProcessor {

    public static Map<String, Integer> processStudentCoursesCSV(String filePath) {
        Map<String, Set<String>> studentCourses = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String studentName = parts[2].trim();
                String courseName = parts[1].trim();

                Set<String> courses = studentCourses.getOrDefault(studentName, new HashSet<>());
                courses.add(courseName);
                studentCourses.put(studentName, courses);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Integer> studentCounts = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : studentCourses.entrySet()) {
            studentCounts.put(entry.getKey(), entry.getValue().size());
        }

        return studentCounts;
    }

    public static void writeStudentCourseCountCSV(String filePath, Map<String, Integer> studentCounts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Student_Name,Course_Count\n");

            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(studentCounts.entrySet());
            sortedEntries.sort(Map.Entry.comparingByKey());

            for (Map.Entry<String, Integer> entry : sortedEntries) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void processEvaluationsCSV(String inputPath, String outputPath) {
        Map<String, List<Evaluation>> evaluationsMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String studentName = parts[0].trim();
                String subjectName = parts[1].trim();
                String evaluationName = parts[3].trim();
                String grade = parts[5].trim();

                evaluationsMap.computeIfAbsent(subjectName, k -> new ArrayList<>())
                        .add(new Evaluation(evaluationName, studentName, Double.parseDouble(grade), subjectName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        writeEvaluationsCSV(outputPath, evaluationsMap);
    }

    private static void writeEvaluationsCSV(String filePath, Map<String, List<Evaluation>> evaluations) {
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