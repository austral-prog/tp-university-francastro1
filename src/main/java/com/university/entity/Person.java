package com.university.entity;

public abstract class Person implements Entity {
    private static int idCounter = 0;
    private int id;
    private String name;

    public Person(String name){
        this.name = name;
        this.id = ++idCounter;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
