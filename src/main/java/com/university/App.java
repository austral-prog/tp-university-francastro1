package com.university;

import com.university.FileReader.Creator;
import com.university.FileReader.Creator1;
import com.university.FileReader.Creator2;
import com.university.csv.CSVReader;
import com.university.csv.CSVWriter;
import com.university.csv.CriteriaProcessor;

import java.util.*;

public class App {

    public static void main(String[] args) {
        try {
        University university = new University();
        Creator creator1 = new Creator1();
        Creator creator2 = new Creator2();
        CriteriaProcessor criteriaProcessor = new CriteriaProcessor();
        CSVReader.processCSV("src/main/resources/input.csv", university, creator1);
        CSVWriter.writeCSV1("src/main/resources/solution.csv", university);
        CSVReader.processCSV("src/main/resources/input_2.csv", university, creator2);
        CSVWriter.writeResults("src/main/resources/solution_2.csv",university);
        CSVReader.processCriteriaCSV("src/main/resources/input_3.csv", criteriaProcessor);
        CSVWriter.generateCSV("src/main/resources/solution_3.csv", university, criteriaProcessor);
        System.out.println("Archivos CSV procesados y escritos exitosamente.");
        } catch (Exception e) {
            System.err.println("Error en la generación de los archivos " + e.getMessage());
            e.printStackTrace();
        }
    }
}
