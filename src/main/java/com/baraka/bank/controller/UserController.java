package com.baraka.bank.controller;

import com.baraka.bank.model.entities.User;
import com.baraka.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }
    @DeleteMapping
    public void delete(@RequestParam Long userId) {
         userService.deleteUser(userId);
    }
}
