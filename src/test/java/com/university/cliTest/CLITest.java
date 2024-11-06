package com.university.cliTest;

package com.university.cli;

import com.university.cli.UniversityCLI;
import com.university.crudrepository.CRUDRepository;
import com.university.crudrepository.CourseRepository;
import com.university.crudrepository.EvaluationRepository;
import com.university.crudrepository.StudentRepository;
import com.university.entity.classroom.Course;
import com.university.entity.classroom.Student;
import com.university.entity.evaluation.Evaluation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testRunCLI_createStudent() {
        String input = "1\n1\nJohn\njohn@example.com\n0"; // Simulating input for creating a student

        // Simulate the input stream
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Run the CLI
        cli.runCLI(new CRUDRepository[]{studentRepo, courseRepo, evaluationRepo});

        // Verify that the student was created
        assertEquals(1, studentRepo.get.size());
        Student createdStudent = studentRepo.getAll().get(0);
        assertEquals("John", createdStudent.getName());
        assertEquals("john@example.com", createdStudent.getEmail());
    }

    @Test
    public void testRunCLI_readStudent() {
        // Setup initial data
        studentRepo.create(new Student("John", "john@example.com"));

        String input = "1\n2\n1\n0"; // Simulating input for reading a student

        // Simulate the input stream
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Run the CLI
        cli.runCLI(new CRUDRepository[]{studentRepo, courseRepo, evaluationRepo});

        // Verify that the correct student was read
        Student readStudent = studentRepo.read(1);
        assertNotNull(readStudent);
        assertEquals("John", readStudent.getName());
        assertEquals("john@example.com", readStudent.getEmail());
    }

    @Test
    public void testRunCLI_updateStudent() {
        // Setup initial data
        studentRepo.create(new Student("John", "john@example.com"));

        String input = "1\n3\n1\nJohn\njohn_updated@example.com\n0"; // Simulating input for updating a student

        // Simulate the input stream
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Run the CLI
        cli.runCLI(new CRUDRepository[]{studentRepo, courseRepo, evaluationRepo});

        // Verify that the student was updated
        Student updatedStudent = studentRepo.read(1);
        assertNotNull(updatedStudent);
        assertEquals("John", updatedStudent.getName());
        assertEquals("john_updated@example.com", updatedStudent.getEmail());
    }

    @Test
    public void testRunCLI_deleteStudent() {
        // Setup initial data
        studentRepo.create(new Student("John", "john@example.com"));

        String input = "1\n4\n1\n0"; // Simulating input for deleting a student

        // Simulate the input stream
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Run the CLI
        cli.runCLI(new CRUDRepository[]{studentRepo, courseRepo, evaluationRepo});

        // Verify that the student was deleted
        Student deletedStudent = studentRepo.read(1);
        assertNull(deletedStudent);
    }

}

