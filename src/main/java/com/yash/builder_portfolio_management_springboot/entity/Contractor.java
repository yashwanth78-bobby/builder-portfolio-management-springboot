package com.yash.builder_portfolio_management_springboot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
    @Column(name = "contractor_email_id")
    private String contractorEmailId;  // PK and also FK to User.userEmailId

    private String contractorName;
    private String contractorPhoneNumber;

    @OneToOne( cascade =CascadeType.REMOVE)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
    private Address address;

    @Column(unique = true)
    private int registrationNumber;

    @OneToOne
    @MapsId  // This maps contractorEmailId to user.userEmailId
    @JoinColumn(name = "contractor_email_id") // FK column reuses PK
    @JsonBackReference
    private User user;
}
