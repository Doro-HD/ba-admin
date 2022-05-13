package com.coderbois.baadmin.service;

import com.coderbois.baadmin.model.User;
import com.coderbois.baadmin.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Troels
    public User findUserByUsername(String username){
        return this.userRepository.findUserByUsername(username);
    }
}
