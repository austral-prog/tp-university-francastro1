package com.university.cli;
/*
import com.university.Creator.EvaluationCreator;
import com.university.crudrepository.CRUDRepository;
import com.university.crudrepository.CourseRepository;
import com.university.crudrepository.EvaluationRepository;
import com.university.crudrepository.StudentRepository;
import com.university.entity.Entity;
import com.university.entity.classroom.Course;
import com.university.entity.classroom.Student;
import com.university.entity.evaluation.Evaluation;

import java.util.Scanner;

public class UniversityCLI implements CLI{

    public void runCLI(CRUDRepository<?>[] crudRepositories) {
        StudentRepository studentRepository = new StudentRepository();
        CourseRepository courseRepository = new CourseRepository();
        EvaluationRepository evaluationRepository = new EvaluationRepository();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            System.out.println("Select entity type: ");
            System.out.println("1. " + studentRepository.getIdentifier());
            System.out.println("2. " + courseRepository.getIdentifier());
            System.out.println("3. " + evaluationRepository.getIdentifier());
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            if (choice == 0) {
                running = false;
                continue;
            }
            if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            // Selección del repositorio basado en la opción del usuario
            CRUDRepository<?> repository = null;
            if (choice == 1) {
                repository = studentRepository;
            } else if (choice == 2) {
                repository = courseRepository;
            } else if (choice == 3) {
                repository = evaluationRepository;
            }

            System.out.println("Selected: " + repository.getIdentifier());
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            int operation = scanner.nextInt();

            switch (choice) {
                case 1: // Student
                    handleStudentOperations(scanner, repository);
                    break;

                case 2: // Course
                    handleCourseOperations(scanner, repository);
                    break;

                case 3: // Evaluation
                    handleEvaluationOperations(scanner, repository);
                    break;

                default:
                    System.out.println("Invalid entity type.");
            }
        }

        scanner.close();
    }

// Métodos auxiliares para manejar operaciones de estudiantes, cursos y evaluaciones

    private void handleStudentOperations(Scanner scanner, CRUDRepository<?> repository) {
        int operation = scanner.nextInt();
        switch (operation) {
            case 1:
                System.out.println("Enter student name and email:");
                String name = scanner.next();
                String email = scanner.next();
                Student student = new Student(name, email);
                // repository.create(student);
                System.out.println("Created: " + student);
                break;
            case 2:
                System.out.println("Enter ID to read:");
                int readId = scanner.nextInt();
                Object readStudent = repository.read(readId);
                System.out.println("Read: " + readStudent);
                break;
            case 3:
                System.out.println("Enter ID to update:");
                int updateId = scanner.nextInt();
                System.out.println("Enter new student name and email:");
                String newName = scanner.next();
                String newEmail = scanner.next();
                Student updatedStudent = new Student(newName, newEmail);
                updatedStudent.setId(updateId);
                // repository.update(updateId, updatedStudent);
                System.out.println("Updated: " + updatedStudent);
                break;
            case 4:
                System.out.println("Enter ID to delete:");
                int deleteId = scanner.nextInt();
                repository.delete(deleteId);
                System.out.println("Deleted entity with ID: " + deleteId);
                break;
            default:
                System.out.println("Invalid operation. Please try again.");
        }
    }

    private void handleCourseOperations(Scanner scanner, CRUDRepository<?> repository) {
        int operation = scanner.nextInt();
        switch (operation) {
            case 1:
                System.out.println("Enter classroom and subject:");
                int classroom = scanner.nextInt();
                String subject = scanner.next();
                Course course = new Course(classroom, subject);
                repository.create(course);
                System.out.println("Created: " + course);
                break;
            case 2:
                System.out.println("Enter ID to read:");
                int readId = scanner.nextInt();
                Object readCourse = repository.read(readId);
                System.out.println("Read: " + readCourse);
                break;
            case 3:
                System.out.println("Enter ID to update:");
                int updateId = scanner.nextInt();
                System.out.println("Enter new classroom and subject:");
                int newClassroom = scanner.nextInt();
                String newSubject = scanner.next();
                Course updatedCourse = new Course(newClassroom, newSubject);
                updatedCourse.setId(updateId);
                repository.update(updateId, updatedCourse);
                System.out.println("Updated: " + updatedCourse);
                break;
            case 4:
                System.out.println("Enter ID to delete:");
                int deleteId = scanner.nextInt();
                repository.delete(deleteId);
                System.out.println("Deleted entity with ID: " + deleteId);
                break;
            default:
                System.out.println("Invalid operation. Please try again.");
        }
    }

    private void handleEvaluationOperations(Scanner scanner, CRUDRepository<?> repository) {
        int operation = scanner.nextInt();
        switch (operation) {
            case 1:
                System.out.println("Enter evaluation name, student name, subject name, and evaluation type:");
                String evalName = scanner.next();
                String studentName = scanner.next();
                String subjectName = scanner.next();
                String evalType = scanner.next();
                Evaluation evaluation = EvaluationCreator.createEvaluation(subjectName, evalName, studentName, evalType);
                repository.create(evaluation);
                System.out.println("Created: " + evaluation);
                break;
            case 2:
                System.out.println("Enter ID to read:");
                int readId = scanner.nextInt();
                Object readEvaluation = repository.read(readId);
                System.out.println("Read: " + readEvaluation);
                break;
            case 3:
                System.out.println("Enter ID to update:");
                int updateId = scanner.nextInt();
                System.out.println("Enter new evaluation name, student name, subject name, and evaluation type:");
                String newEvalName = scanner.next();
                String newStudentName = scanner.next();
                String newSubjectName = scanner.next();
                String newEvalType = scanner.next();
                Evaluation updatedEvaluation = EvaluationCreator.createEvaluation(newSubjectName, newEvalName, newStudentName, newEvalType);
                updatedEvaluation.setId(updateId);
                repository.update(updateId, updatedEvaluation);
                System.out.println("Updated: " + updatedEvaluation);
                break;
            case 4:
                System.out.println("Enter ID to delete:");
                int deleteId = scanner.nextInt();
                repository.delete(deleteId);
                System.out.println("Deleted entity with ID: " + deleteId);
                break;
            default:
                System.out.println("Invalid operation. Please try again.");
        }
    }

}

//import java.util.Scanner;
/*
public class UniversityCLI implements CLI{
    private Scanner scanner = new Scanner(System.in);

    public void runCLI(CRUDRepository<?>[] crudRepositories) {
        boolean running = true;
        while (running) {
            displayMenu(crudRepositories);
            int choice = scanner.nextInt();
            if (choice == 0) {
                running = false;
                continue;
            }
            if (choice < 1 || choice > crudRepositories.length) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }
            CRUDRepository<?> repository = crudRepositories[choice - 1];
            System.out.println("Selected: " + repository.getIdentifier());
            int operation = displayOperationMenu();
            switch (operation) {
                case 1:
                    createEntity(repository);
                    break;
                case 2:
                    readEntity(repository);
                    break;
                case 3:
                    updateEntity(repository);
                    break;
                case 4:
                    deleteEntity(repository);
                    break;
                default:
                    System.out.println("Invalid operation. Please try again.");
            }
        }
        scanner.close();
    }

    private void displayMenu(CRUDRepository<?>[] crudRepositories) {
        System.out.println("Select entity type: ");
        for (int i = 0; i < crudRepositories.length; i++) {
            System.out.println((i + 1) + ". " + crudRepositories[i].getIdentifier());
        }
        System.out.println("0. Exit");
    }

    private int displayOperationMenu() {
        System.out.println("Select operation: ");
        System.out.println("1. Create");
        System.out.println("2. Read");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        return scanner.nextInt();
    }

    private void createEntity(CRUDRepository<?> repository) {
        if (repository instanceof StudentRepository) {
            System.out.println("Enter student name and email:");
            String name = scanner.next();
            String email = scanner.next();
            Student student = new Student(name, email);
            repository.create(student);
            System.out.println("Created: " + student);
        } else if (repository instanceof CourseRepository) {
            System.out.println("Enter classroom and subject:");
            int classroom = scanner.nextInt();
            String subject = scanner.next();
            Course course = new Course(classroom, subject);
            repository.create(course);
            System.out.println("Created: " + course);
        } else if (repository instanceof EvaluationRepository) {
            System.out.println("Enter evaluation name, student name, subject name, and evaluation type:");
            String evalName = scanner.next();
            String studentName = scanner.next();
            String subjectName = scanner.next();
            String evalType = scanner.next();
            Evaluation evaluation = EvaluationCreator.createEvaluation(subjectName, evalName, studentName, evalType);
            repository.create(evaluation);
            System.out.println("Created: " + evaluation);
        }
    }

    private void readEntity(CRUDRepository<?> repository) {
        System.out.println("Enter ID to read:");
        int readId = scanner.nextInt();
        Object readEntity = repository.read(readId);
        System.out.println("Read: " + readEntity);
    }

    private void updateEntity(CRUDRepository<?> repository) {
        System.out.println("Enter ID to update:");
        int updateId = scanner.nextInt();
        Object entityToUpdate = null;

        // Search for the entity in the repository using a for loop
        for (int i = 0; i < repository.size(); i++) {
            Object entity = repository.read(i);
            if (entity != null && entity.getId() == updateId) {
                entityToUpdate = entity;
                break;
            }
        }

        if (entityToUpdate != null) {
            if (entityToUpdate instanceof Student) {
                updateStudent((Student) entityToUpdate, repository);
            } else if (entityToUpdate instanceof Course) {
                updateCourse((Course) entityToUpdate, repository);
            } else if (entityToUpdate instanceof Evaluation) {
                updateEvaluation((Evaluation) entityToUpdate, repository);
            }
        } else {
            System.out.println("Entity not found.");
        }
    }

    private void updateStudent(Student studentToUpdate, CRUDRepository<?> repository) {
        System.out.println("Current Name: " + studentToUpdate.getName() + ", Current Email: " + studentToUpdate.getEmail());
        System.out.println("Enter new student name and email:");
        String newName = scanner.next();
        String newEmail = scanner.next();
        studentToUpdate.setName(newName);
        studentToUpdate.setEmail(newEmail);
        repository.update(studentToUpdate.getId(), studentToUpdate);
        System.out.println("Updated: " + studentToUpdate);
    }

    private void updateCourse(Course courseToUpdate, CRUDRepository<?> repository) {
        System.out.println("Current Classroom: " + courseToUpdate.getClassroom() + ", Current Subject: " + courseToUpdate.getSubject());
        System.out.println("Enter new classroom and subject:");
        int newClassroom = scanner.nextInt();
        String newSubject = scanner.next();
        courseToUpdate.setClassroom(newClassroom);
        courseToUpdate.setSubject(newSubject);
        repository.update(courseToUpdate.getId(), courseToUpdate);
        System.out.println("Updated: " + courseToUpdate);
    }

    private void updateEvaluation(Evaluation evaluationToUpdate, CRUDRepository<?> repository) {
        System.out.println("Current Evaluation: " + evaluationToUpdate.getName());
        System.out.println("Enter new evaluation name, student name, subject name, and evaluation type:");
        String newEvalName = scanner.next();
        String newStudentName = scanner.next();
        String newSubjectName = scanner.next();
        String newEvalType = scanner.next();
        Evaluation updatedEvaluation = EvaluationCreator.createEvaluation(newSubjectName, newEvalName, newStudentName, newEvalType);
        updatedEvaluation.setId(evaluationToUpdate.getId());
        repository.update(updatedEvaluation.getId(), updatedEvaluation);
        System.out.println("Updated: " + updatedEvaluation);
    }

    private void deleteEntity(CRUDRepository<?> repository) {
        System.out.println("Enter ID to delete:");
        int deleteId = scanner.nextInt();
        repository.delete(deleteId);
        System.out.println("Deleted entity with ID: " + deleteId);
    }
}
*/