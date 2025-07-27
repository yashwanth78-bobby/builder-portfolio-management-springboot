package com.yash.builder_portfolio_management_springboot.service;


import com.yash.builder_portfolio_management_springboot.entity.Address;
import com.yash.builder_portfolio_management_springboot.entity.Contractor;
import com.yash.builder_portfolio_management_springboot.repository.ContratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractorService {

    @Autowired
    private ContratorRepository contratorRepository;

    // Create a new contractor
    public Contractor createContractor(String contractorEmailId, String contractorName, String contractorPhoneNumber, Address address, int registrationNumber) {
        Contractor newContractor = Contractor.builder()
                .contractorEmailId(contractorEmailId)
                .contractorName(contractorName)
                .contractorPhoneNumber(contractorPhoneNumber)
                .address(address)
                .registrationNumber(registrationNumber)
                .build();
        return contratorRepository.save(newContractor);
    }

    // Update an existing contractor
    public Contractor updateContractor(String contractorEmailId, Contractor updatedContractor) {
        Optional<Contractor> existingContractor = contratorRepository.findById(contractorEmailId);
        if (existingContractor.isPresent()) {
            Contractor contractor = existingContractor.get();
            contractor.setContractorName(updatedContractor.getContractorName());
            contractor.setContractorPhoneNumber(updatedContractor.getContractorPhoneNumber());
            contractor.setAddress(updatedContractor.getAddress());
            contractor.setRegistrationNumber(updatedContractor.getRegistrationNumber());
            return contratorRepository.save(contractor);
        } else {
            throw new RuntimeException("Contractor not found with email ID: " + contractorEmailId);
        }
    }

    // Retrieve a contractor by email ID
    public Contractor getContractorById(String contractorEmailId) {
        return contratorRepository.findById(contractorEmailId)
                .orElseThrow(() -> new RuntimeException("Contractor not found with email ID: " + contractorEmailId));
    }

    // Delete a contractor by email ID
    public void deleteContractor(String contractorEmailId) {
        if (contratorRepository.existsById(contractorEmailId)) {
            contratorRepository.deleteById(contractorEmailId);
        } else {
            throw new RuntimeException("Contractor not found with email ID: " + contractorEmailId);
        }
    }
}