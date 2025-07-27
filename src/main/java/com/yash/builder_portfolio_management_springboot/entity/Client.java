package com.yash.builder_portfolio_management_springboot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yash.builder_portfolio_management_springboot.enums.ClientType;
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
public class Client {
    @Id
    @Column(name = "client_email_id")
    private String clientEmailId;
    private String clientName;
    private ClientType clientType;

    @OneToOne
    @JoinColumn(name= "address_id",referencedColumnName = "addressId")
    private Address address;

    private String phoneNumber;
    @OneToOne
    @MapsId  // This maps contractorEmailId to user.userEmailId
    @JoinColumn(name = "client_email_id") // FK column reuses PK
    @JsonBackReference
    private User user;
}
