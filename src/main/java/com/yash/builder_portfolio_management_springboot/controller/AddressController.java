package com.yash.builder_portfolio_management_springboot.controller;

import com.yash.builder_portfolio_management_springboot.entity.Address;
import com.yash.builder_portfolio_management_springboot.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;
    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address createdAddress = addressService.createAddress(address.getHouseNo(), address.getArea(), address.getCity(), address.getState(), address.getPincode());
        return ResponseEntity.ok(createdAddress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable("id") int addressId, @RequestBody Address updatedAddress) {
        Address address = addressService.updateAddress(addressId, updatedAddress);
        return ResponseEntity.ok(address);
    }

    // Retrieve an address by ID
    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") int addressId) {
        Address address = addressService.getAddressById(addressId);
        return ResponseEntity.ok(address);
    }

    // Delete an address by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable("id") int addressId) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.noContent().build();
    }
}