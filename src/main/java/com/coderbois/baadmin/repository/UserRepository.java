package com.coderbois.baadmin.repository;

import com.coderbois.baadmin.model.User;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//Troels
public class UserRepository {

    private JdbcConnector jdbcConnector;

    public UserRepository(){
        this.jdbcConnector = new JdbcConnector();

    }

    //Troels
    public User findUserByUsername(String username){
        String SQL = "SELECT * FROM users WHERE username = " + username;
        Statement statement = jdbcConnector.getPreparedStatement(SQL);
        User user = new User();

        if(statement != null) {
            try {
                ResultSet userResultSet = statement.executeQuery(SQL);
                while (userResultSet.next()){

                    user.setUsername(userResultSet.getString("username"));
                    user.setPassword(userResultSet.getString("password"));
                    user.setRole(userResultSet.getString("role"));


                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            user = null;
        }


        return user;
    }
}
