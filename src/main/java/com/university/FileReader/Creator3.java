package com.university.FileReader;

import com.university.University;

public class Creator3 implements Creator{
    @Override
    public void create(String[] parts, University university) {
        String subjectName = parts[0].trim();
        String criteriaType = parts[1].trim();
        String criteriaValue = parts[2].trim();
        String evaluationName = parts[3].trim();

        //csv3 = student, subject, aprobado/desaprobado
    }
}
