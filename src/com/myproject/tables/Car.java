package com.myproject.tables;

public class Car {

    private int id;
    private String carModel;
    private String carNumber;
    private  Driver driver;

    public Car(int id, String carModel, String carNumber, Driver driver) {
        this.id = id;
        this.carModel = carModel;
        this.carNumber = carNumber;
        this.driver = driver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "car id " + id +
                ", carModel '" + carModel + '\'' +
                ", carNumber '" + carNumber + '\'' + ", " +
                driver;
    }
}
