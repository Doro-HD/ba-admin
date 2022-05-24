package com.coderbois.baadmin.service;

import com.coderbois.baadmin.model.User;
import com.coderbois.baadmin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Author
//Daivd
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Author
    //David
    public User findUserByUsername(String username) {
        return this.userRepository.findUserByUsername(username);
    }
}
