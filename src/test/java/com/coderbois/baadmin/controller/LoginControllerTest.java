package com.coderbois.baadmin.controller;

import com.coderbois.baadmin.model.User;
import com.coderbois.baadmin.repository.UserRepository;
import com.coderbois.baadmin.security.PasswordManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

    @Test
    void loginPost() {
        String correctPassword = "admin1";
        String wrongPassword = "wrong";

        PasswordManager passwordManager = new PasswordManager();

        UserRepository userRepository = new UserRepository();
        User user = userRepository.findUserByUsername("admin1");

        boolean passwordIsCorrect = passwordManager.validatePassword(correctPassword, user.getPassword());
        assertTrue(passwordIsCorrect);

        boolean passwordIsWrong = passwordManager.validatePassword(wrongPassword, user.getPassword());
        assertFalse(passwordIsWrong);
    }
}