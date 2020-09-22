package com.damnjan.restapitest.controllers;

import com.damnjan.restapitest.entity.User;
import com.damnjan.restapitest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

//    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/id")
    public ResponseEntity<User> getUserByID(@PathVariable Integer id) {
        return new ResponseEntity<>(userService.getUserbyID(id), HttpStatus.OK);
    }


}
