package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

   /* @Override
    public List<User> getAllUser() {
        List<User> allUser = userRepository.findAll();
        return allUser;
    }*/

    @Override
    public User getUser(Long userId) {
        User getUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with given userID : " + userId));
        return getUser;
    }

    @Override
    public void deleteUser(Long userID) {
        userRepository.deleteById(userID);
    }

    @Override
    public User updateUser(User user, Long userId) {
        User getUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with given userID : " + userId));

        if (getUser != null) {
            getUser.setUserId(userId);
            getUser.setName(user.getName());
            getUser.setCity(user.getCity());
        }

        User updatedUser = userRepository.save(getUser);
        return updatedUser;
    }
}
