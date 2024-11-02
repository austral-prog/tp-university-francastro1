package com.university.FileReader;

import com.university.Creator.CourseCreator;
import com.university.Creator.StudentCreator;
import com.university.University;
import com.university.entity.classroom.Course;
import com.university.entity.classroom.Student;

public class Creator1 implements Creator{
    @Override
    public void create(String[] parts, University university) {
        int classroom = Integer.parseInt(parts[0]);
        String subject = parts[1].trim();
        String studentName = parts[2].trim();
        String email = parts[3].trim();
        StudentCreator studentCreator = new StudentCreator();
        CourseCreator courseCreator = new CourseCreator(university.getCourses());
        Student student = studentCreator.getOrCreateStudent(studentName, email, university.getStudents());
        Course course = courseCreator.getOrCreateCourse(classroom, subject);
        student.addToCourse(course);
        course.addStudent(student);
    }
}
