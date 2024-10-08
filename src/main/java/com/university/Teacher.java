package com.university;

public class Teacher extends Person {
    private String subject;

    public Teacher(String name, String subject, int id){
        super(name);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }


}
