package com.university.FileReader.creator;

import com.university.Creator.CourseCreator;
import com.university.Creator.StudentCreator;
import com.university.University;
import com.university.entity.evaluation.criteria.CriteriaProcessor;
import com.university.entity.classroom.Course;
import com.university.entity.classroom.Student;

public class Creator1 implements Creator {
    @Override
    public void create(String parts, University university, CriteriaProcessor criteriaProcessor) {
        StudentCreator studentCreator = new StudentCreator(university.getStudents());
        CourseCreator courseCreator = new CourseCreator(university.getCourses());
        Student student = studentCreator.getOrCreate(parts, university.getStudents(), university);
        Course course = courseCreator.getOrCreate(parts, university.getCourses(), university);
        student.addToCourse(course);
        course.addStudent(student);
    }
}
