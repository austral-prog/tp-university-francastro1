package com.university.entity.evaluation.criteria;

import com.university.University;
import com.university.entity.classroom.Student;
import com.university.entity.evaluation.Evaluation;
import com.university.entity.evaluation.FinalExam;
import com.university.entity.evaluation.WrittenExam;

import java.util.*;
import java.util.List;

public class CriteriaProcessor {
    private List<Criterion> criteriaList = new ArrayList<>();

    public void addCriteria(Criterion criteria) {
        criteriaList.add(criteria);
    }

    public List<Criterion> getCriteriaList() {
        return criteriaList;
    }

    private Criterion findCriterionForSubject(String subject) {
        for (Criterion criterion : criteriaList) {
            if (criterion.getSubjectName().equals(subject)) {
                return criterion;
            }
        }
        return null;
    }

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
                Criterion criterion = findCriterionForSubject(subject);
                boolean passed = false;
                if (criterion != null) {
                    passed = criterion.evaluate(student);
                }
                String status;
                if (passed) {
                    status = "PASSED";
                } else {
                    status = "FAILED";
                }
                results.add(student.getName() + "," + subject + "," + status);
            }
        }
        return results;
    }
}


