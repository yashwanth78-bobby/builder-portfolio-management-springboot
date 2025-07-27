package com.yash.builder_portfolio_management_springboot.service;


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
    public Contractor createContractor(Contractor contractor) {
        return contratorRepository.save(contractor);
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
            contractor.setUser(updatedContractor.getUser());
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