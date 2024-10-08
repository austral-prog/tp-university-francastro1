package com.university;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class App {

    public static void main(String[] args) {

        String inputPath1 = "src/main/resources/input.csv";
        String outputPath1 = "src/main/resources/solution.csv";

        Map<String, Integer> studentCounts = CSVProcessor.processStudentCoursesCSV(inputPath1);
        CSVProcessor.writeStudentCourseCountCSV(outputPath1, studentCounts);

        String inputPath2 = "src/main/resources/input_2.csv"; // Asegúrate de que este archivo tenga el contenido correcto
        String outputPath2 = "src/main/resources/solution_2.csv";

        CSVProcessor.processEvaluationsCSV(inputPath2, outputPath2);

        System.out.println("Archivos CSV procesados y escritos exitosamente.");

    }
}
