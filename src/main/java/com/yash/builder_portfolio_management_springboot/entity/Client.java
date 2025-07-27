package com.yash.builder_portfolio_management_springboot.entity;

import com.yash.builder_portfolio_management_springboot.enums.ClientType;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    @Id
    private String clientEmailId;
    private String clientName;
    private ClientType clientType;
    @OneToOne
    @JoinColumn(name= "address_id",referencedColumnName = "addressId")
    private Address address;

    private String phoneNumber;
}
