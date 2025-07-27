package com.yash.builder_portfolio_management_springboot.service;

import com.yash.builder_portfolio_management_springboot.entity.User;
import com.yash.builder_portfolio_management_springboot.enums.Role;
import com.yash.builder_portfolio_management_springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public void createUser(String userEmailId, String password, Role role) {
        User user = User.builder()
                .userEmailId(userEmailId)
                .passwordHash(password)
                .role(role)
                .build();
        userRepository.save(user);
    }

    public void updateUser(String userEmailId, String newPassword) {
        Optional<User> optionalUser = userRepository.findById(userEmailId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPasswordHash(newPassword);
            userRepository.save(user);
        } else {
            throw new RuntimeException("User with email " + userEmailId + " not found.");
        }
    }

    public void deleteUser(String userEmailId) {
        if (userRepository.existsById(userEmailId)) {
            userRepository.deleteById(userEmailId);
        } else {
            throw new RuntimeException("User with email " + userEmailId + " not found.");
        }
    }

    public User getUserDetails(String userEmailId) {
        return userRepository.findById(userEmailId)
                .orElseThrow(() -> new RuntimeException("User with email " + userEmailId + " not found."));
    }
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new RuntimeException("No users found.");
        }
        return users;
    }
}