package com.university.csv;

import com.university.FileReader.Creator;
import com.university.University;
import com.university.entity.evaluation.Criterion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    public static void processCSV(String filePath, University university, Creator creator) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                creator.create(parts, university);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void processCriteriaCSV(String filePath, CriteriaProcessor criteriaProcessor) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] values = line.split(",");

                String subjectName = values[0];
                String criteriaType = values[1];
                double criteriaValue = Double.parseDouble(values[2]);
                String[] evaluationNames = Arrays.copyOfRange(values, 3, values.length);

                Criterion criterion = new Criterion(subjectName, criteriaType, criteriaValue, List.of(evaluationNames));
                criteriaProcessor.addCriteria(criterion);
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo de criterios: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Error de formato numérico en el archivo de criterios: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
