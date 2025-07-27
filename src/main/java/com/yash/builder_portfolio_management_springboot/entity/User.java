package com.yash.builder_portfolio_management_springboot.entity;


import com.yash.builder_portfolio_management_springboot.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private String userEmailId;
    private String passwordHash;
    private Role role;
    @OneToOne(mappedBy = "user")
    Contractor contractor;
    @OneToOne(mappedBy = "user")
    Client client;
}
