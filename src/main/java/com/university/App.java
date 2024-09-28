package com.university;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class App {

    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/input.csv";
        String outputFilePath = "src/main/resources/solution.csv";

        Map<String, Integer> studentCourseCounts = processCSV(inputFilePath);
        writeOutputCSV(outputFilePath, studentCourseCounts);
    }

    private static Map<String, Integer> processCSV(String filePath) {
        Map<String, Set<String>> studentCourses = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String studentName = parts[2].trim();
                String courseName = parts[1].trim();
                Set<String> courses = studentCourses.get(studentName);
                if (courses == null) {
                    courses = new HashSet<>();
                    studentCourses.put(studentName, courses);
                }
                courses.add(courseName);
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

    private static void writeOutputCSV(String filePath, Map<String, Integer> studentCounts) {
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
}
