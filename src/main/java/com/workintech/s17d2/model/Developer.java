package com.workintech.s17d2.model;

import com.workintech.s17d2.Experience;


public  class Developer  {
    private int id;
    private String name;
    private double salary;
    private Experience experience;


    public Developer(int id , String name , double salary , Experience experience) {
        this.experience = experience;
        this.salary = salary;
        this.name = name;
        this.id = id;
    }

    public Developer() {

    }


    public Experience getExperience() {
        return experience;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }


    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
