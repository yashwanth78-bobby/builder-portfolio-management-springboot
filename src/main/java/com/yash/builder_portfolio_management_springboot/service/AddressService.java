package com.yash.builder_portfolio_management_springboot.service;

import com.yash.builder_portfolio_management_springboot.entity.Address;
import com.yash.builder_portfolio_management_springboot.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    // Create a new address
    public Address createAddress(String houseNo, String area, String city, String state, int pincode) {
        Address address = Address.builder()
                .houseNo(houseNo)
                .area(area)
                .city(city)
                .state(state)
                .pincode(pincode)
                .build();
        return addressRepository.save(address);
    }

    // Update an existing address
    public Address updateAddress(int addressId, Address updatedAddress) {
        Optional<Address> existingAddress = addressRepository.findById(addressId);
        if (existingAddress.isPresent()) {
            Address address = existingAddress.get();
            address.setHouseNo(updatedAddress.getHouseNo());
            address.setArea(updatedAddress.getArea());
            address.setCity(updatedAddress.getCity());
            address.setState(updatedAddress.getState());
            address.setPincode(updatedAddress.getPincode());
            return addressRepository.save(address);
        } else {
            throw new RuntimeException("Address not found with ID: " + addressId);
        }
    }

    // Retrieve an address by ID
    public Address getAddressById(int addressId) {
        return addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found with ID: " + addressId));
    }

    // Delete an address by ID
    public void deleteAddress(int addressId) {
        if (addressRepository.existsById(addressId)) {
            addressRepository.deleteById(addressId);
        } else {
            throw new RuntimeException("Address not found with ID: " + addressId);
        }
    }
}