package com.myproject.tables;

import java.sql.Date;

public class Fixation {

    private int id;
    private Date fixDate;
    private Car car;
    private Foul foul;

    public Fixation(int id, Date fixDate, Car car, Foul foul) {
        this.id = id;
        this.fixDate = fixDate;
        this.car = car;
        this.foul = foul;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFixDate() {
        return fixDate;
    }

    public void setFixDate(Date fixDate) {
        this.fixDate = fixDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Foul getFoul() {
        return foul;
    }

    public void setFoul(Foul foul) {
        this.foul = foul;
    }

    @Override
    public String toString() {
        return "Fixation id " + id +
                ", fixDate " + fixDate + ", " +
                car + foul;
    }
}
