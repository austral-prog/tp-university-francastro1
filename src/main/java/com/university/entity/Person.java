package com.university.entity;

import com.university.Entity;

public abstract class Person implements Entity {

    private String name;
    private int id;

    public Person(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
