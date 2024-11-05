package com.university.cli;

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

public class CastingCLI implements CLI{

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

            CRUDRepository<? extends Entity> repository = null;
            switch (choice) {
                case 1:
                    repository = new StudentRepository();
                    break;
                case 2:
                    repository = new CourseRepository();
                    break;
                case 3:
                    repository = new EvaluationRepository();
                    break;
            }

            entityOperations(scanner, repository);
        }
        scanner.close();
    }
// metodos para manejar operaciones

    private void entityOperations(Scanner scanner, CRUDRepository<? extends Entity> repository) {
        System.out.println("Selected: " + repository.getIdentifier());
        System.out.println("1. Create");
        System.out.println("2. Read");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        int operation = scanner.nextInt();

        switch (operation) {
            case 1:
                studentOperations(scanner, (CRUDRepository<Student>) repository);
                break;
            case 2:
                courseOperations(scanner, (CRUDRepository<Course>) repository);
                break;
            case 3:
                evaluationOperations(scanner, (CRUDRepository<Evaluation>) repository);
                break;
            default:
                System.out.println("Invalid entity type.");
        }
    }
    private void studentOperations(Scanner scanner, CRUDRepository<Student> repository) {
        int operation = scanner.nextInt();
        switch (operation) {
            case 1:
                System.out.println("Enter student name and email:");
                String name = scanner.next();
                String email = scanner.next();
                Student student = new Student(name, email);
                repository.create(student);
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
                Student existingStudent = findEntityById(repository, updateId);
                System.out.println("Enter new student name and email:");
                String newName = scanner.next();
                String newEmail = scanner.next();
                existingStudent.setName(newName);
                existingStudent.setEmail(newEmail);
                repository.update(updateId, existingStudent);
                System.out.println("Updated: " + existingStudent);
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

    private void courseOperations(Scanner scanner, CRUDRepository<Course> repository) {
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
                Course existingCourse = findEntityById(repository, updateId);
                System.out.println("Enter new classroom and subject:");
                int newClassroom = scanner.nextInt();
                String newSubject = scanner.next();
                existingCourse.setClassroom(newClassroom);
                existingCourse.setSubject(newSubject);
                repository.update(updateId, existingCourse);
                System.out.println("Updated: " + existingCourse);
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

    private void evaluationOperations(Scanner scanner, CRUDRepository<Evaluation> repository) {
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
                Evaluation existingEvaluation = findEntityById(repository, updateId);
                System.out.println("Enter new evaluation name, student name, subject name, and evaluation type:");
                String newEvalName = scanner.next();
                String newStudentName = scanner.next();
                String newSubjectName = scanner.next();
                String newEvalType = scanner.next();
                existingEvaluation.setName(newEvalName);
                existingEvaluation.setStudentName(newStudentName);
                existingEvaluation.setSubjectName(newSubjectName);
                existingEvaluation.setEvaluationType(newEvalType);
                repository.update(updateId, existingEvaluation);
                System.out.println("Updated: " + existingEvaluation);
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

    public <T extends Entity> T findEntityById(CRUDRepository<T> repository, int id) {
    T entity = repository.read(id);
    if (entity == null) {
        throw new EntityNotFoundException("Entity with ID " + id + " not found.");
    }
    return entity;
}


}

