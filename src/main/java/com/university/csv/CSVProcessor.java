package com.university.csv;

import com.university.University;
import com.university.classroom.Course;
import com.university.entity.Student;
import com.university.test.evaluation.Evaluation;

import java.io.*;
import java.util.*;

public class CSVProcessor {

    public static void processCSV1(String filePath, University university) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String studentName = parts[2].trim();
                String courseName = parts[1].trim();
                String email = parts[3].trim();

                Student student = university.getStudents().stream()
                        .filter(s -> s.getName().equals(studentName))
                        .findFirst()
                        .orElse(null);

                if (student == null) {
                    student = new Student(studentName, email);
                    university.addStudent(student);
                }

                Course course = university.getCourses().stream()
                        .filter(c -> c.getClassroom() == Integer.parseInt(parts[0].trim()))
                        .findFirst()
                        .orElse(null);

                if (course == null) {
                    course = new Course(Integer.parseInt(parts[0].trim()), null); // Asumiendo que Teacher es opcional
                    university.addCourse(course);
                }

                student.addToCourse(course);
                course.addStudent(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeCSV1(String filePath, University university) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Student_Name,Course_Count\n");

            Map<String, Integer> studentCounts = university.getStudentCourseCounts();

            // Usando Sorter para ordenar alfabéticamente
            List<Map.Entry<String, Integer>> sortedEntries = Sorter.sortByName(studentCounts);

            for (Map.Entry<String, Integer> entry : sortedEntries) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void processCSV2(String inputPath, String outputPath) {
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

        writeCSV2(outputPath, evaluationsMap);
    }

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