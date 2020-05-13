package com.myproject.tables;

public class Driver {

    private int id;
    private String name;
    private String surname;
    private int certificate;
    private int phoneNumber;

    public Driver(int id, String name, String surname, int certificate, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.certificate = certificate;
        this.phoneNumber = phoneNumber;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCertificate() {
        return certificate;
    }

    public void setCertificate(int certificate) {
        this.certificate = certificate;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return  "driver id " + id +
                ", name '" + name + '\'' +
                ", surname '" + surname + '\'' +
                ", certificate " + certificate +
                ", phoneNumber " + phoneNumber + ", ";
    }
}
