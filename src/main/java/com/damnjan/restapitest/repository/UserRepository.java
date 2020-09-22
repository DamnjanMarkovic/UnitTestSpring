package com.damnjan.restapitest.repository;

import com.damnjan.restapitest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
