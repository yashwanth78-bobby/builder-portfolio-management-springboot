package com.yash.builder_portfolio_management_springboot.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yash.builder_portfolio_management_springboot.enums.Role;
import com.yash.builder_portfolio_management_springboot.service.ContractorService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_table")
public class User {

    @Id
    private String userEmailId;

    private String passwordHash;

    private Role role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Contractor contractor;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Client client;
}
