package com.yash.builder_portfolio_management_springboot.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

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
