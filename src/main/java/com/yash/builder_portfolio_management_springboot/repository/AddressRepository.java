package com.yash.builder_portfolio_management_springboot.repository;

import com.yash.builder_portfolio_management_springboot.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    // Additional query methods can be defined here if needed
}
