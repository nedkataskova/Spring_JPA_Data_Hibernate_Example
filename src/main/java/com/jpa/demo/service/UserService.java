package com.jpa.demo.service;

import com.jpa.demo.model.User;
import com.jpa.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User findUserByEmail(String email){
        return userRepository.findByEmailAddress(email);
    }

    public List<User> findUserOnAgeBetween(int minAge, int maxAge) {
        return userRepository.findUsersBetweenAges(minAge, maxAge);
    }
}
