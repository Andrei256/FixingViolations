package com.myproject.services;


import com.myproject.DBManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarService {

    private static final String INSERT_NEW_USER_QUERY = "insert into cars value(null, ?, ?, ?)";
    private static final String GET_ID_BY_CAR_NUMBER_QUERY = "select id from cars where car_number = ?";

    public void addNewCar(String model, String number, int driverId) throws SQLException {

        PreparedStatement statement = DBManager.getConnection().prepareStatement(INSERT_NEW_USER_QUERY);
        statement.setString(1, model);
        statement.setString(2, number);
        statement.setInt(3, driverId);

        statement.execute();
    }

    public int getIdByCarNumber(String carNumber) throws SQLException {

        PreparedStatement statement = DBManager.getConnection().prepareStatement(GET_ID_BY_CAR_NUMBER_QUERY);
        statement.setString(1, carNumber);
        ResultSet resultSet = statement.executeQuery();

        if (!resultSet.next()) {
            System.err.println("No car with number found " + carNumber + ". Enter 3 to add a car.");
        }

        return resultSet.getInt("id");
    }
}
