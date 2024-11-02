package com.university.test;

import com.university.Entity;

public class Exercise implements Entity {

    private String name;

    public Exercise(String name){
        this.name = name;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    public String getName() {
        return this.name;
    }
}
