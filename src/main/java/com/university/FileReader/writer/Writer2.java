package com.university.FileReader.writer;

import com.university.University;
import com.university.entity.evaluation.criteria.CriteriaProcessor;
import com.university.csv.Sorter;
import com.university.entity.evaluation.Evaluation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class Writer2 implements Writer {
    @Override
    public void write(University university, CriteriaProcessor criteriaProcessor, BufferedWriter writer) throws IOException {
        writer.write("Subject_Name,Evaluation_Name,Student_Name,Grade");
        writer.newLine();
        List<Evaluation> evaluations = university.getEvaluations();
        List<Evaluation> sortedEvaluations = Sorter.sortEvaluations(evaluations);
        for (Evaluation eval : sortedEvaluations) {
            writer.write(eval.getSubjectName() + "," +
                    eval.getName() + "," +
                    eval.getStudentName() + "," +
                    eval.getGrade());
            writer.newLine();
        }
    }
}
