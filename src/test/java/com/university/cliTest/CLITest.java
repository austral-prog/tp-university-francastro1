package com.university.cliTest;

import com.university.cli.UniversityCLI;

import com.university.crudrepository.CRUDRepository;
import com.university.crudrepository.CourseRepository;
import com.university.crudrepository.EvaluationRepository;
import com.university.crudrepository.StudentRepository;
import com.university.entity.classroom.Course;
import com.university.entity.classroom.Student;
import com.university.entity.evaluation.Evaluation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class CLITest {

    private UniversityCLI cli;
    private CRUDRepository<Student> studentRepo;
    private CRUDRepository<Course> courseRepo;
    private CRUDRepository<Evaluation> evaluationRepo;

    @BeforeEach
    public void setup() {
        studentRepo = new StudentRepository();
        courseRepo = new CourseRepository();
        evaluationRepo = new EvaluationRepository();
        cli = new UniversityCLI();
    }

    @AfterEach
    public void tearDown() {
        studentRepo.getRepo().clear();
        courseRepo.getRepo().clear();
        evaluationRepo.getRepo().clear();
    }

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
}
