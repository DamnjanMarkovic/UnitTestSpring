package com.damnjan.restapitest.service;

import com.damnjan.restapitest.entity.User;

import java.util.List;

public interface UserServiceInterface {

    public User getUserbyID(Integer id);

    public List<User> findAll();
}
