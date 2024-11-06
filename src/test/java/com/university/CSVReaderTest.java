package com.university;

import com.university.FileReader.creator.Creator;
import com.university.FileReader.creator.Creator1;
import com.university.csv.CSVReader;
import com.university.entity.evaluation.Evaluation;
import com.university.entity.evaluation.criteria.CriteriaProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CSVReaderTest {

    private String filePath;

    @BeforeEach
    public void setUp() {
        // Inicializamos la ruta del archivo de prueba
        filePath = "test.csv";
    }

    @Test
    public void testProcessCSVSuccessfully() throws IOException {
        // Crear un archivo de prueba con datos simulados
        String csvContent = "id,name,subject\n1,John,Math\n2,Jane,Physics\n";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(csvContent);
        }

        // Creamos los objetos necesarios
        University university = new University();
        Creator creator = new Creator1();  // Suponiendo que Creator tiene el método create
        CriteriaProcessor criteriaProcessor = new CriteriaProcessor(); // Lo mismo con CriteriaProcessor

        // Llamar al método a probar
        CSVReader.processCSV(filePath, university, creator, criteriaProcessor);

        // Verificar que los datos fueron procesados correctamente
        // Aquí verificamos si las entidades han sido creadas correctamente en el sistema
        List<Evaluation> evaluations = university.getEvaluations(); // Suponiendo que University tiene este método
        assertEquals(2, evaluations.size());
        assertEquals("John", evaluations.get(0).getStudentName());
        assertEquals("Math", evaluations.get(0).getSubjectName());
    }

    @Test
    public void testEmptyFile() throws IOException {
        String csvContent = "";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(csvContent);
        }
        University university = new University();
        Creator creator = new Creator1();
        CriteriaProcessor criteriaProcessor = new CriteriaProcessor();
        CSVReader.processCSV(filePath, university, creator, criteriaProcessor);
        List<Evaluation> evaluations = university.getEvaluations();
        assertEquals(0, evaluations.size());
    }

    @Test
    public void testFileNotFound() {
        String invalidFilePath = "invalid.csv";
        University university = new University();
        Creator creator = new Creator1();
        CriteriaProcessor criteriaProcessor = new CriteriaProcessor();
        CSVReader.processCSV(invalidFilePath, university, creator, criteriaProcessor);
    }
}
