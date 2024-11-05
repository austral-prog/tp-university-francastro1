package com.university;

import com.university.FileReader.creator.Creator;
import com.university.FileReader.creator.Creator1;
import com.university.FileReader.creator.Creator2;
import com.university.FileReader.creator.Creator3;
import com.university.FileReader.writer.Writer;
import com.university.FileReader.writer.Writer1;
import com.university.FileReader.writer.Writer2;
import com.university.FileReader.writer.Writer3;
import com.university.csv.CSVReader;
import com.university.csv.CSVWriter;
import com.university.entity.evaluation.criteria.CriteriaProcessor;

public class App {

    public static void main(String[] args) {
        try {
            University university = new University();
            Creator creator1 = new Creator1();
            Creator creator2 = new Creator2();
            Creator creator3 = new Creator3();
            Writer writer1 = new Writer1();
            Writer writer2 = new Writer2();
            Writer writer3 = new Writer3();
            CriteriaProcessor criteriaProcessor = new CriteriaProcessor();
            CSVReader.processCSV("src/main/resources/input.csv", university, creator1, criteriaProcessor);
            CSVWriter.writeCSV("src/main/resources/solution.csv", university, criteriaProcessor, writer1);
            CSVReader.processCSV("src/main/resources/input_2.csv", university, creator2, criteriaProcessor);
            CSVWriter.writeCSV("src/main/resources/solution_2.csv",university, criteriaProcessor, writer2);
            CSVReader.processCSV("src/main/resources/input_3.csv", university, creator3, criteriaProcessor);
            CSVWriter.writeCSV("src/main/resources/solution_3.csv", university, criteriaProcessor, writer3);
            System.out.println("Archivos CSV procesados y escritos exitosamente.");
        } catch (Exception e) {
            System.err.println("Error en la generación de los archivos " + e.getMessage());
            e.printStackTrace();
        }
    }
}
