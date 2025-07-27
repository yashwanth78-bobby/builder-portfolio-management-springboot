package com.yash.builder_portfolio_management_springboot.repository;

import com.yash.builder_portfolio_management_springboot.entity.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratorRepository extends JpaRepository<Contractor, Integer> {
    // Additional query methods can be defined here if needed
}
