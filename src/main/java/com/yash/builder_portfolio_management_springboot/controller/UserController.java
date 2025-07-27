package com.yash.builder_portfolio_management_springboot.controller;

import com.yash.builder_portfolio_management_springboot.entity.User;
import com.yash.builder_portfolio_management_springboot.enums.Role;
import com.yash.builder_portfolio_management_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void createUser(@RequestParam String userEmailId, @RequestParam String password, @RequestParam Role role) {
        userService.createUser(userEmailId, password, role);
    }

    @PutMapping("/{userEmailId}")
    public void updateUser(@PathVariable String userEmailId, @RequestParam String newPassword) {
        userService.updateUser(userEmailId, newPassword);
    }

    @DeleteMapping("/{userEmailId}")
    public void deleteUser(@PathVariable String userEmailId) {
        userService.deleteUser(userEmailId);
    }

    @GetMapping("/{userEmailId}")
    public User getUserDetails(@PathVariable String userEmailId) {
        return userService.getUserDetails(userEmailId);
    }
}
