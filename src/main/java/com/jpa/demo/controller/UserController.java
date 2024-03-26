package com.jpa.demo.controller;

import com.jpa.demo.exception.ResourceNotFoundException;
import com.jpa.demo.model.User;
import com.jpa.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/find")
    public User addProduct(@RequestParam String email) throws ResourceNotFoundException {
        User user = service.findUserByEmail(email);
        if(Objects.isNull(user)) throw new ResourceNotFoundException("User not found");
        return user;
    }

    @GetMapping("/findUsersBetweenAge")
    public List<User> findUsersBetweenAge(@RequestParam int minAge, @RequestParam int maxAge) throws ResourceNotFoundException {
        List<User> users = service.findUserOnAgeBetween(minAge, maxAge);
        if(Objects.isNull(users)) throw new ResourceNotFoundException("User not found");
        return users;
    }

}
