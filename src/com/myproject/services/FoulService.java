package com.myproject.services;


import com.myproject.DBManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FoulService {

    private static final String INSERT_NEW_USER_QUERY = "insert into fouls value(null, ?)";
    private static final String GET_ID_BY_NAME_FOUL_QUERY = "select id from fouls where name_foul = ?";

    public void addNewFoul(String nameFoul) throws SQLException {

        PreparedStatement statement = DBManager.getConnection().prepareStatement(INSERT_NEW_USER_QUERY);
        statement.setString(1, nameFoul);

        statement.execute();
    }

    public int getIdByNameFoul(String nameFoul) throws SQLException {

        PreparedStatement statement = DBManager.getConnection().prepareStatement(GET_ID_BY_NAME_FOUL_QUERY);
        statement.setString(1, nameFoul);
        ResultSet resultSet = statement.executeQuery();

        if (!resultSet.next())
            System.err.println("No foul with the name " + nameFoul + ". Enter 4 to add a new foul.");

        return resultSet.getInt("id");
    }


}
