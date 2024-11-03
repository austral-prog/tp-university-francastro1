package com.university.csv;

import com.university.University;
import com.university.entity.classroom.Student;
import com.university.entity.evaluation.Criterion;
import com.university.entity.evaluation.Evaluation;
import java.util.*;
import java.util.List;

public class CriteriaProcessor {
    private List<Criterion> criteriaList = new ArrayList<>();

    public void addCriteria(Criterion criteria) {
        criteriaList.add(criteria);
    }

    private Criterion findCriterionForSubject(String subject) {
        for (Criterion criterion : criteriaList) {
            if (criterion.getSubjectName().equals(subject)) {
                return criterion;
            }
        }
        return null;
    }/*
    public List<String> evaluateStudents(University university, List<Criterion> criteria) {
        List<String> results = new ArrayList<>();

        for (Student student : university.getStudents()) {
            // Mapa para agrupar evaluaciones por materia
            Map<String, List<Evaluation>> subjectEvaluations = new HashMap<>();

            // Agrupar evaluaciones por el nombre de la materia
            for (Evaluation evaluation : student.getEvaluations()) {
                String subject = evaluation.getSubjectName();
                subjectEvaluations.computeIfAbsent(subject, k -> new ArrayList<>()).add(evaluation);
            }

            // Evaluar el estado de cada materia usando los criterios definidos
            for (Map.Entry<String, List<Evaluation>> entry : subjectEvaluations.entrySet()) {
                String subject = entry.getKey();
                List<Evaluation> evaluations = entry.getValue();

                // Inicializar criterio como nulo
                Criterion criterion = null;

                // Buscar un criterio correspondiente para la materia usando un bucle for
                for (Criterion c : criteria) {
                    if (c.getSubjectName().equals(subject)) {
                        criterion = c; // Encontrar el criterio
                        break; // Salir del bucle una vez encontrado
                    }
                }

                // Determinar el estado según el criterio
                String status = "FAILED"; // Asumimos "FAILED" como predeterminado
                if (criterion != null) {
                    // Evaluar al estudiante con el criterio correspondiente
                    boolean isPassed = criterion.evaluate(student);
                    status = isPassed ? "PASSED" : "FAILED";
                }

                // Agregar el resultado
                results.add(student.getName() + "," + subject + "," + status);
            }
        }
        return results;
    }
    */
    public List<String> evaluateStudents(University university) {
        List<String> results = new ArrayList<>();

        for (Student student : university.getStudents()) {
            Map<String, List<Evaluation>> subjectEvaluations = new HashMap<>();
            for (Evaluation evaluation : student.getEvaluations()) {
                String subject = evaluation.getSubjectName();
                if (!subjectEvaluations.containsKey(subject)) {
                    subjectEvaluations.put(subject, new ArrayList<>());
                }
                subjectEvaluations.get(subject).add(evaluation);
            }
            for (Map.Entry<String, List<Evaluation>> entry : subjectEvaluations.entrySet()) {
                String subject = entry.getKey();
                List<Evaluation> evaluations = entry.getValue();
                Criterion criterion = findCriterionForSubject(subject);
                boolean passed = false;
                if (criterion != null) {
                    passed = criterion.evaluate(student);
                }
                String status = passed ? "PASSED" : "FAILED";
                results.add(student.getName() + "," + subject + "," + status);
            }
        }
        return results;
    }
}

