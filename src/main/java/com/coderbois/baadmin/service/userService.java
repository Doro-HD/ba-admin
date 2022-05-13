package com.coderbois.baadmin.service;

import com.coderbois.baadmin.repository.UserRepository;

public class userService {
    private UserRepository userRepository;

    public boolean findUserByUsername(){
        return this.userRepository.findeUserByUsername();
    }
}
