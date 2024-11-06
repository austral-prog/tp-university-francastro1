package com.university.csvTest;

import com.university.FileReader.writer.Writer1;
import com.university.University;
import com.university.csv.CSVWriter;
import com.university.entity.evaluation.OralExam;
import com.university.entity.evaluation.WrittenExam;
import com.university.entity.evaluation.criteria.CriteriaProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CSVWriterTest {

    private String filePath;

    @BeforeEach
    public void setUp() {
        filePath = "output.csv";
    }

    @Test
    public void testWriteCSVSuccessfully() throws IOException {
        // Creamos un archivo CSV de prueba
        University university = new University();
        // Suponemos que el objeto University tiene un método que agrega evaluaciones
        university.addEvaluation(new WrittenExam("Midterm", "John Doe", "Math", "WRITTEN_EXAM"));
        university.addEvaluation(new OralExam("Final", "Jane Smith", "Physics", "ORAL_EXAM"));

        CriteriaProcessor criteriaProcessor = new CriteriaProcessor();  // Asumimos que tiene un comportamiento específico

        // Llamamos al método a probar
        CSVWriter.writeCSV(filePath, university, criteriaProcessor, new Writer1());

        // Verificamos si el archivo fue creado
        assertTrue(Files.exists(Paths.get(filePath)));

        // Leemos el contenido del archivo
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        // Verificamos que las líneas escritas son las esperadas
        assertEquals(3, lines.size()); // Encabezado + 2 evaluaciones
        assertTrue(lines.get(1).contains("John Doe"));
        assertTrue(lines.get(2).contains("Jane Smith"));

        // Limpiar el archivo después de la prueba
        Files.delete(Paths.get(filePath));
    }

    @Test
    public void testWriteCSVHandlesEmptyUniversity() throws IOException {
        // Crear una universidad vacía
        University university = new University();
        CriteriaProcessor criteriaProcessor = new CriteriaProcessor();

        // Llamamos al método a probar
        CSVWriter.writeCSV(filePath, university, criteriaProcessor, new Writer1());

        // Verificamos que el archivo se haya creado pero esté vacío
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        assertEquals(1, lines.size()); // Solo el encabezado
        assertTrue(lines.get(0).contains("id,name,subject"));

        // Limpiar el archivo después de la prueba
        Files.delete(Paths.get(filePath));
    }

    @Test
    public void testWriteCSVHandlesIOException() {
        // Usamos una ruta inválida para simular una excepción de escritura
        String invalidFilePath = "/invalid_directory/output.csv";
        University university = new University();
        CriteriaProcessor criteriaProcessor = new CriteriaProcessor();

        // Intentamos escribir el archivo y verificamos que se lance una IOException
        try {
            CSVWriter.writeCSV(invalidFilePath, university, criteriaProcessor, new Writer1());
            fail("Expected IOException was not thrown");
        } catch (IOException e) {
            assertTrue(e.getMessage().contains("No such file or directory"));
        }
    }
}

