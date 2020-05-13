package com.myproject.services;

import com.myproject.DBManager;
import com.myproject.tables.Car;
import com.myproject.tables.Fixation;
import com.myproject.tables.Foul;
import com.myproject.tables.Driver;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FixationService {

    private static final String INSERT_NEW_USER_QUERY = "insert into fixation value(null, ?, ?, ?)";
    public static final String GET_ALL_FIXATIONS = "select * from drivers d join cars c on (d.id = c.driver_id)" +
            "  join  fixation fi on (c.id = fi.car_id) join fouls f on (fi.foul_id = f.id);";
    public static final String DELETE_FIXATION = "delete from fixation where id = ?;";
    public static final String CHECK = "select id, foul_id from fixation where car_id = ?;";

    public void addNewFixation(Date date, int carId, int foulId) throws SQLException {

        PreparedStatement statement = DBManager.getConnection().prepareStatement(INSERT_NEW_USER_QUERY);
        statement.setDate(1, date);
        statement.setInt(2, carId);
        statement.setInt(3, foulId);

        statement.execute();
    }

    public List<Fixation> getAllFixationData() throws SQLException {

        Connection connection = DBManager.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(GET_ALL_FIXATIONS);
        List<Fixation> resultList = new ArrayList<>();

        while (resultSet.next()) {
            int driverId = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            int certificate = resultSet.getInt(4);
            int phoneNumber = resultSet.getInt(5);

            int carId = resultSet.getInt(6);
            String carModel = resultSet.getString(7);
            String carNumber = resultSet.getString(8);

            int fixId = resultSet.getInt(10);
            Date fixDate = resultSet.getDate(11);
            int foulId = resultSet.getInt(14);
            String foulText = resultSet.getString(15);

            Fixation fixation = new Fixation(fixId, fixDate, new Car(carId, carModel, carNumber, new Driver(driverId, name, surname, certificate, phoneNumber)), new Foul(foulId, foulText));

            resultList.add(fixation);
        }
        return resultList;
    }

    public void printAllFixationData() throws SQLException {
        getAllFixationData().forEach(System.out::println);
    }

    public void deleteFixation(int carId) throws SQLException {

        PreparedStatement statementFirst = DBManager.getConnection().prepareStatement(CHECK);
        statementFirst.setInt(1, carId);
        ResultSet resultSet = statementFirst.executeQuery();

        while (resultSet.next()) {
            if (resultSet.getInt(2) != 3) {
                PreparedStatement statementSecond = DBManager.getConnection().prepareStatement(DELETE_FIXATION);
                // Тут берем айди машины и удаляем возможные нарушения по ID нарушения
                statementSecond.setInt(resultSet.getInt(1), carId);
                statementSecond.execute();
                System.out.println("Нарушение удалено");
            } else if (resultSet.getInt(2) == 3)
                System.err.println("Error 9999999999999999");
        }
    }

    public Date setDate () throws IOException {
        IOService ioService = new IOService();
        Date date;
        System.out.println("Введите дату в формате: гггг мм дд");
        String input = ioService.getInputString();
        String[] split = input.split(" ");
        int year = Integer.parseInt(split[0].trim()) - 1900;
        int month = Integer.parseInt(split[1].trim()) - 1;
        int day = Integer.parseInt(split[2].trim()) + 1;
        date = new Date(year, month, day);
    return date;
    }

}
