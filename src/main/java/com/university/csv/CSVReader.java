package com.university.csv;

import com.university.FileReader.Creator;
import com.university.University;

import java.io.BufferedReader;
import java.io.FileReader;

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
}
