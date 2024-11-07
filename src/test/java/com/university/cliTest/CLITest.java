package com.university.cliTest;

import com.university.cli.UniversityCLI;

import com.university.crudrepository.CRUDRepository;
import com.university.crudrepository.CourseRepository;
import com.university.crudrepository.EvaluationRepository;
import com.university.crudrepository.StudentRepository;
import com.university.entity.classroom.Course;
import com.university.entity.classroom.Student;
import com.university.entity.evaluation.Evaluation;
import com.university.entity.evaluation.FinalExam;
import com.university.entity.evaluation.OralExam;
import com.university.entity.evaluation.WrittenExam;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class CLITest {

    private UniversityCLI cli;
    private CRUDRepository<Student> studentRepo;
    private CRUDRepository<Course> courseRepo;
    private CRUDRepository<Evaluation> evaluationRepo;
    private ByteArrayOutputStream output;

    @BeforeEach
    public void setup() {
        studentRepo = new StudentRepository();
        courseRepo = new CourseRepository();
        evaluationRepo = new EvaluationRepository();
        cli = new UniversityCLI();
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void tearDown() {
        studentRepo.getRepo().clear();
        courseRepo.getRepo().clear();
        evaluationRepo.getRepo().clear();
    }

    private void setInput(String data) {
        InputStream input = new ByteArrayInputStream(data.getBytes());
        System.setIn(input);
    }
/*
    @Test
    public void testCLIcreate() {
        String input = "1\n1\nJohn\njohn@example.com\n0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        cli.runCLI(new CRUDRepository[]{studentRepo, courseRepo, evaluationRepo});
        Student createdStudent = studentRepo.read(1);
        assertNotNull(createdStudent);
        assertEquals("John", createdStudent.getName());
        assertEquals("john@example.com", createdStudent.getEmail());
    }
*/
    @Test
    public void testCLIread() {
        studentRepo.create(new Student("John", "john@example.com"));
        String input = "1\n2\n1\n0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        cli.runCLI(new CRUDRepository[]{studentRepo, courseRepo, evaluationRepo});
        Student readStudent = studentRepo.read(1);
        assertNotNull(readStudent);
        assertEquals("John", readStudent.getName());
        assertEquals("john@example.com", readStudent.getEmail());
    }
/*
    @Test
    public void testCLIupdate() {
        studentRepo.create(new Student("John", "john@example.com"));
        String input = "1\n3\n1\nJohn\njohn_updated@example.com\n0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        cli.runCLI(new CRUDRepository[]{studentRepo, courseRepo, evaluationRepo});
        Student updatedStudent = studentRepo.read(1);
        assertNotNull(updatedStudent);
        assertEquals("John", updatedStudent.getName());
        assertEquals("john_updated@example.com", updatedStudent.getEmail());
    }
*/
    @Test
    public void testCLIdelete() {
        studentRepo.create(new Student("John", "john@example.com"));
        String input = "1\n4\n1\n0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        cli.runCLI(new CRUDRepository[]{studentRepo, courseRepo, evaluationRepo});
        Student deletedStudent = studentRepo.read(1);
        assertNull(deletedStudent);
    }

/*
    @Test
    void testRunCLI_CreateCourse() {
        setInput("2\n1\n101\nMath\n0\n");
        CRUDRepository<?>[] repositories = {studentRepo, courseRepo, evaluationRepo};
        cli.runCLI(repositories);
        Course createdCourse = courseRepo.read(1);
        assertNotNull(createdCourse);
        assertEquals(101, createdCourse.getClassroom());
        assertEquals("Math", createdCourse.getSubject());
        String result = output.toString();
        assertTrue(result.contains("Created:"));
    }
*/
    @Test
    void testRunCLI_ReadCourse() {
        Course course = new Course(101, "Math");
        courseRepo.create(course);
        setInput("2\n2\n1\n0\n");
        CRUDRepository<?>[] repositories = {studentRepo, courseRepo, evaluationRepo};
        cli.runCLI(repositories);
        String result = output.toString();
        assertTrue(result.contains("Read:"));
        assertTrue(result.contains("Math"));
    }
/*
    @Test
    void testRunCLI_UpdateCourse() {
        Course course = new Course(101, "Math");
        courseRepo.create(course);
        setInput("2\n3\n1\n102\nPhysics\n0\n");
        CRUDRepository<?>[] repositories = {studentRepo, courseRepo, evaluationRepo};
        cli.runCLI(repositories);
        Course updatedCourse = courseRepo.read(1);
        assertNotNull(updatedCourse);
        assertEquals(102, updatedCourse.getClassroom());
        assertEquals("Physics", updatedCourse.getSubject());
        String result = output.toString();
        assertTrue(result.contains("Updated:"));
    }
*/
    @Test
    void testRunCLI_DeleteCourse() {
        Course course = new Course(101, "Math");
        courseRepo.create(course);
        setInput("2\n4\n1\n0\n");
        CRUDRepository<?>[] repositories = {studentRepo, courseRepo, evaluationRepo};
        cli.runCLI(repositories);
        Course deletedCourse = courseRepo.read(1);
        assertNull(deletedCourse);
        String result = output.toString();
        assertTrue(result.contains("Deleted entity with ID:"));
    }
/*
    @Test
    void testRunCLI_CreateEvaluation() {
        setInput("3\n1\nMidterm\nJohn Doe\nMath\nFINAL_EXAM\n0\n");
        CRUDRepository<?>[] repositories = {studentRepo, courseRepo, evaluationRepo};
        cli.runCLI(repositories);
        Evaluation createdEvaluation = evaluationRepo.read(1);
        assertNotNull(createdEvaluation);
        assertEquals("Midterm", createdEvaluation.getName());
        assertEquals("John Doe", createdEvaluation.getStudentName());
        assertEquals("Math", createdEvaluation.getSubjectName());
        String result = output.toString();
        assertTrue(result.contains("Created:"));
    }
*/
    @Test
    void testRunCLI_ReadEvaluation() {
        OralExam evaluation = new OralExam("Midterm", "John Doe", "Math", "ORAL_EXAM");
        evaluationRepo.create(evaluation);
        setInput("3\n2\n1\n0\n");
        CRUDRepository<?>[] repositories = {studentRepo, courseRepo, evaluationRepo};
        cli.runCLI(repositories);
        String result = output.toString();
        assertTrue(result.contains("Read:"));
        assertTrue(result.contains("Midterm"));
    }
/*
    @Test
    void testRunCLI_UpdateEvaluation() {
        FinalExam evaluation = new FinalExam("Midterm", "John Doe", "Math", "FINAL_PRACTICAL_WORK");
        evaluationRepo.create(evaluation);
        setInput("3\n3\n1\nFinal\nJane Doe\nHistory\nFinalExam\n0\n");
        CRUDRepository<?>[] repositories = {studentRepo, courseRepo, evaluationRepo};
        cli.runCLI(repositories);
        Evaluation updatedEvaluation = evaluationRepo.read(1);
        assertNotNull(updatedEvaluation);
        assertEquals("Final", updatedEvaluation.getName());
        assertEquals("Jane Doe", updatedEvaluation.getStudentName());
        assertEquals("History", updatedEvaluation.getSubjectName());
        String result = output.toString();
        assertTrue(result.contains("Updated:"));
    }
*/
    @Test
    void testRunCLI_DeleteEvaluation() {
        WrittenExam evaluation = new WrittenExam("Midterm", "John Doe", "Math", "WRITTEN_EXAM");
        evaluationRepo.create(evaluation);
        setInput("3\n4\n1\n0\n");
        CRUDRepository<?>[] repositories = {studentRepo, courseRepo, evaluationRepo};
        cli.runCLI(repositories);
        Evaluation deletedEvaluation = evaluationRepo.read(1);
        assertNull(deletedEvaluation);
        String result = output.toString();
        assertTrue(result.contains("Deleted entity with ID:"));
    }

}

