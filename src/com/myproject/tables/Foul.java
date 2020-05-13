package com.myproject.tables;

public class Foul {

    private int id;
    private String nameFoul;

    public Foul(int id, String nameFoul) {
        this.id = id;
        this.nameFoul = nameFoul;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameFoul() {
        return nameFoul;
    }

    public void setNameFoul(String nameFoul) {
        this.nameFoul = nameFoul;
    }

    @Override
    public String toString() {
        return "foul id " + id +
                ", nameFoul '" + nameFoul + '\'';
    }
}
