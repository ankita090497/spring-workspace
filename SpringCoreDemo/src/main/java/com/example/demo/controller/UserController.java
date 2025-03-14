package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User user){
       User createdUser =  userService.saveUser(user);
       return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId){
        User user =  userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long userId){
        User updatedUser =  userService.updateUser(user,userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedUser);
    }

}
