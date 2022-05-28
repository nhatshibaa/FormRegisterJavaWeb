package com.example.javawebday1.model;

import com.example.javawebday1.entity.Phone;
import com.example.javawebday1.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySQLPhoneModel implements IPhone {

    @Override
    public Phone save(Phone phone) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into phone " +
                    "(id, name, brand, price, description) " +
                    "values " +
                    "(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, phone.getId());
            preparedStatement.setString(2, phone.getName());
            preparedStatement.setString(3, phone.getBrand());
            preparedStatement.setDouble(4, phone.getPrice());
            preparedStatement.setString(5, phone.getDescription());
            System.out.println("Connection success!");
            preparedStatement.execute();
            return phone;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Phone> findAll() {
        List<Phone> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from phone where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String brand = resultSet.getString("brand");
                Double price = Double.valueOf(resultSet.getString("price"));
                String description = resultSet.getString("description");
                Phone phoneUser = new Phone(id, name, brand, price, description);
                list.add(phoneUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
