package com.coderbois.baadmin.service;

import com.coderbois.baadmin.model.User;
import com.coderbois.baadmin.repository.UserRepository;

public class userService {
    private UserRepository userRepository;

    public User findUserByUsername(String username){
        return this.userRepository.findUserByUsername(username);
    }
}
