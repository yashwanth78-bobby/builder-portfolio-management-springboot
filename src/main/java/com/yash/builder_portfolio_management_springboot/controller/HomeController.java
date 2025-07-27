package com.yash.builder_portfolio_management_springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class HomeController {
    // This controller can be used to handle requests for the home page or root URL.
    // You can add methods here to return views or data as needed.

    // Example method to return a welcome message
     @GetMapping("/")
     public String home() {
         return "Welcome to the Builder Portfolio Management System!";
     }
}
