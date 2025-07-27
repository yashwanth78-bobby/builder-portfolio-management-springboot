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

public class Contractor {
    @Id
    private String contractorEmailId;
    private String contractorName;
    private String contractorPhoneNumber;
    @OneToOne
    @JoinColumn(name= "address_id",referencedColumnName = "addressId")
    private int addressId;
    private int registrationNumber;
    @OneToOne
    @JoinColumn(name = "user_email_id", referencedColumnName = "userEmailId")
    private User user;

}
