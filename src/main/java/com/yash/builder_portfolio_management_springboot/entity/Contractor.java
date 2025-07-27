package com.yash.builder_portfolio_management_springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

class Contractor {
    @Id
    private String builderEmailId;
    private String builderName;
    private String builderPhoneNumber;
    private int addressId;
    private int registrationNumber;
    @OneToOne
    @JoinColumn(name = "builderEmailId", referencedColumnName = "userEmailId")
    private User user;

}
