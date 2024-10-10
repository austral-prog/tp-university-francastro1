package com.university;

public class Teacher extends Person {
    private String subject;
    private int id;

    public Teacher(String name, String subject, int id){
        super(name);
        this.subject = subject;
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public int getId() {
        return id;
    }
}

