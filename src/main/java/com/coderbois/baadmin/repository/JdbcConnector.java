package com.coderbois.baadmin.repository;

import java.sql.*;

//Klassen er taget fra miniprojekt: oenskebroenen
public class JdbcConnector {

    private static Connection connection;

    static {
        String url = System.getenv("db_url");
        String userName = System.getenv("db_username");
        String password = System.getenv("db_password");

        try {
            connection = DriverManager.getConnection(url, userName, password);

        } catch (SQLException e) {
            System.out.println("Forbindelse fejlede");
            e.printStackTrace();
        }
    }

    Statement getStatement() {
        Statement statement;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return statement;
    }

    PreparedStatement getPreparedStatement(String sql) {
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return preparedStatement;
    }
}

