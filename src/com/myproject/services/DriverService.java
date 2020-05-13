package com.myproject.services;


import com.myproject.DBManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverService {

    private static final String INSERT_NEW_USER_QUERY = "insert into drivers value(null, ?, ?, ?, ?)";
    private static final String GET_ID_BY_CERTIFICATE_QUERY = "select id from drivers where certificate = ?";

    public void addNewDriver(String name, String surname, int certificate, int phoneNumber) throws SQLException {

        PreparedStatement statement = DBManager.getConnection().prepareStatement(INSERT_NEW_USER_QUERY);
        statement.setString(1, name);
        statement.setString(2, surname);
        statement.setInt(3, certificate);
        statement.setInt(4, phoneNumber);

        statement.execute();
    }

    public int getIdByCertificate(int certificate) throws SQLException {

        PreparedStatement statement = DBManager.getConnection().prepareStatement(GET_ID_BY_CERTIFICATE_QUERY);
        statement.setInt(1, certificate);
        ResultSet resultSet = statement.executeQuery();

        if (!resultSet.next())
            System.err.println("No driver with number certificate " + certificate + ". Enter 2 to add a driver.");

        return resultSet.getInt("id");
    }
}
