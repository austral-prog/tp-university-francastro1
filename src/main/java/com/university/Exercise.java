package com.university;

public class Exercise implements Entity{

    private String name;

    public Exercise(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
