package com.yash.builder_portfolio_management_springboot.repository;

import com.yash.builder_portfolio_management_springboot.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}
