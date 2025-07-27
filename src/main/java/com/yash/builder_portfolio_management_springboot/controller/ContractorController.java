package com.yash.builder_portfolio_management_springboot.controller;


import com.yash.builder_portfolio_management_springboot.entity.Contractor;
import com.yash.builder_portfolio_management_springboot.service.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/contractors")
public class ContractorController {

    @Autowired
    private ContractorService contractorService;

    @PostMapping
    public ResponseEntity<Contractor> createContractor(@RequestBody Contractor contractor) {
        Contractor createdContractor = contractorService.createContractor(contractor.getContractorEmailId(), contractor.getContractorName(),
                contractor.getContractorPhoneNumber(), contractor.getAddress(), contractor.getRegistrationNumber());
        return ResponseEntity.ok(createdContractor);
    }

    @PutMapping("/{contractorEmailId}")
    public ResponseEntity<Contractor> updateContractor(
            @PathVariable String contractorEmailId,
            @RequestBody Contractor updatedContractor) {
        Contractor contractor = contractorService.updateContractor(contractorEmailId, updatedContractor);
        return ResponseEntity.ok(contractor);
    }

    @GetMapping("/{contractorEmailId}")
    public ResponseEntity<Contractor> getContractorById(@PathVariable String contractorEmailId) {
        Contractor contractor = contractorService.getContractorById(contractorEmailId);
        return ResponseEntity.ok(contractor);
    }

    @DeleteMapping("/{contractorEmailId}")
    public ResponseEntity<Void> deleteContractor(@PathVariable String contractorEmailId) {
        contractorService.deleteContractor(contractorEmailId);
        return ResponseEntity.noContent().build();
    }
}