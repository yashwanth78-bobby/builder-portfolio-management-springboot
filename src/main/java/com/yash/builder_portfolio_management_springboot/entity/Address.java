package com.yash.builder_portfolio_management_springboot.entity;

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
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_seq",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_seq")
    private int addressId;
    private String houseNo;
    private String area;
    private String city;
    private String state;
    private int pincode;

}
