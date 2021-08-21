package com.prehax.award.models;

public class Customer {
    private int id;
    private String name;
    private int awardPoints;

    public Customer(int id, String name, int awardPoints) {
        this.id = id;
        this.name = name;
        this.awardPoints = awardPoints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAwardPoints() {
        return awardPoints;
    }

    public void setAwardPoints(int awardPoints) {
        this.awardPoints = awardPoints;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", awardPoints=" + awardPoints +
                '}';
    }
}
