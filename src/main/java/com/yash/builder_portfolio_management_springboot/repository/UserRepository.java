package com.yash.builder_portfolio_management_springboot.repository;

import com.yash.builder_portfolio_management_springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
