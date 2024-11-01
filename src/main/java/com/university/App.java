package com.university;

import com.university.csv.CSVProcessor;

import java.util.*;

public class App {

    public static void main(String[] args) {
        University university = new University();
        CSVProcessor.processCSV1("src/main/resources/students.csv", university);
        CSVProcessor.writeCSV1("src/main/resources/solution.csv", university);

        String inputPath2 = "src/main/resources/input_2.csv";
        String outputPath2 = "src/main/resources/solution_2.csv";

        CSVProcessor.processCSV2(inputPath2, outputPath2);

        System.out.println("Archivos CSV procesados y escritos exitosamente.");

    }
}
