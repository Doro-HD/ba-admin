package com.coderbois.baadmin.repository;

import java.sql.*;



public class JdbcConnector {
    //HELE KLASSEN ER COPY PASTED FRA MINI (PRUT)PROJEEEEEEKT
    private Connection connection;


    public JdbcConnector() {
        String url = System.getenv("db_url");
        String userName = System.getenv("db_username");
        String password = System.getenv("db_password");

        try {
            this.connection = DriverManager.getConnection(url, userName, password);

            Statement statement = this.connection.createStatement();
            statement.executeQuery("/* ping */ SELECT 1");

        } catch (SQLException e) {
            System.out.println("Forbindelse fejlede");
            e.printStackTrace();
        }
    }

    Statement getStatement() {
        Statement statement;
        try {
            statement = this.connection.createStatement();
        } catch (SQLException e) {
            //Todo: remove the print stack trace below when we move to production
            e.printStackTrace();
            return null;
        }

        return statement;
    }

    PreparedStatement getPreparedStatement(String sql) {
        PreparedStatement preparedStatement;

        try {
            preparedStatement = this.connection.prepareStatement(sql);
        } catch (SQLException e) {
            //Todo: remove the print stack trace below when we move to production
            e.printStackTrace();
            return null;
        }

        return preparedStatement;
    }
}

