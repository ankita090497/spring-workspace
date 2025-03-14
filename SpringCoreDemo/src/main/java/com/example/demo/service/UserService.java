package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;



public interface UserService {

    //create
    User saveUser(User user);

    // getALL
  //  List<User> getAllUser();

    User getUser(Long userId);

    void deleteUser(Long userID);


    User updateUser(User user, Long userId);
}
