package com.damnjan.restapitest.controllers;

import com.damnjan.restapitest.entity.User;
import com.damnjan.restapitest.repository.UserRepository;
import com.damnjan.restapitest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/all")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;




    @GetMapping("/")
    public List<User> all() {
        return userService.findAll();
    }

    @GetMapping("/user/id")
    public ResponseEntity<User> getUserByID(@PathVariable Integer id) {
        return new ResponseEntity<>(userService.getUserbyID(id), HttpStatus.OK);
    }


}
