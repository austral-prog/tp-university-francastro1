package com.university;

import com.university.csv.CSVProcessor;

import java.util.*;

public class App {

    public static void main(String[] args) {

        String inputPath1 = "src/main/resources/input.csv";
        String outputPath1 = "src/main/resources/solution.csv";

        Map<String, Integer> studentCounts = CSVProcessor.processCSV1(inputPath1);
        CSVProcessor.writeCSV1(outputPath1, studentCounts);

        String inputPath2 = "src/main/resources/input_2.csv";
        String outputPath2 = "src/main/resources/solution_2.csv";

        CSVProcessor.processCSV2(inputPath2, outputPath2);

        System.out.println("Archivos CSV procesados y escritos exitosamente.");

    }
}
