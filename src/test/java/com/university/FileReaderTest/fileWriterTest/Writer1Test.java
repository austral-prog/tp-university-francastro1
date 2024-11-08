package com.university.FileReaderTest.fileWriterTest;

import com.university.FileReader.writer.Writer1;
import com.university.University;
import com.university.entity.classroom.Course;
import com.university.entity.classroom.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Writer1Test {

    private University university;
    private Writer1 writer1;

    @BeforeEach
    void setUp() {
        university = new University();
        writer1 = new Writer1();
    }

    @Test
    void testWrite() throws IOException {
        Student student1 = new Student("John Doe", "johndoe@gmail.com");
        Student student2 = new Student("Jane Smith", "janesmith@gmail.com");
        Course course1 = new Course(505,"Math");
        Course course = new Course(345,"Economics");
        Course course2 = new Course(102,"Art");
        student2.addToCourse(course);
        student2.addToCourse(course1);
        student2.addToCourse(course2);
        student1.addToCourse(course);
        student1.addToCourse(course1);
        university.addStudent(student1);
        university.addStudent(student2);
        StringWriter stringWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(stringWriter);
        writer1.write(university, null, bufferedWriter);
        bufferedWriter.flush();
        String expectedOutput =
                "Student_Name,Course_Count\n" +
                        "Jane Smith,3\n" +
                        "John Doe,2\n";
        assertEquals(expectedOutput, stringWriter.toString(), "La salida generada debe coincidir con el formato esperado.");
    }
}

