package com.university;

public class Teacher {
    private String name;
    private String subject;
    private int id;

    public Teacher(String name, String subject, int id){
        this.name = name;
        this.subject = subject;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }


}
