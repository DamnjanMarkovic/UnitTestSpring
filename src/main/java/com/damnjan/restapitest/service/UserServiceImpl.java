package com.damnjan.restapitest.service;

import com.damnjan.restapitest.entity.User;
import com.damnjan.restapitest.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

//    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserbyID(Integer id) {
        return userRepository.findById(id).get();
    }
}
