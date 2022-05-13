package com.coderbois.baadmin.repository;

import com.coderbois.baadmin.model.User;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//Troels
@Repository
public class UserRepository {

    private JdbcConnector jdbcConnector;

    public UserRepository(){
        this.jdbcConnector = new JdbcConnector();

    }

    //Troels
    public User findUserByUsername(String username){
        final String SQL = "SELECT * FROM users WHERE username = '" + username + "'";
        Statement statement = jdbcConnector.getStatement();
        User user = new User();

        if(statement != null) {
            try {
                ResultSet userResultSet = statement.executeQuery(SQL);
                while (userResultSet.next()){

                    user.setUsername(userResultSet.getString("username"));
                    user.setPassword(userResultSet.getString("user_password"));
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
