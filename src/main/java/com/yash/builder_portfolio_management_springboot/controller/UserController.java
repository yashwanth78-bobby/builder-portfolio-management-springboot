package com.yash.builder_portfolio_management_springboot.controller;

import com.yash.builder_portfolio_management_springboot.entity.User;
import com.yash.builder_portfolio_management_springboot.enums.Role;
import com.yash.builder_portfolio_management_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user.getUserEmailId(), user.getPasswordHash(), user.getRole());
    }

    @PutMapping("/{userEmailId}")
    public void updateUser(@PathVariable String userEmailId, @RequestBody User user) {
        userService.updateUser(userEmailId, user.getPasswordHash());
    }

    @DeleteMapping("/{userEmailId}")
    public void deleteUser(@PathVariable String userEmailId) {
        userService.deleteUser(userEmailId);
    }

    @GetMapping("/{userEmailId}")
    public User getUserDetails(@PathVariable String userEmailId) {
        return userService.getUserDetails(userEmailId);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
