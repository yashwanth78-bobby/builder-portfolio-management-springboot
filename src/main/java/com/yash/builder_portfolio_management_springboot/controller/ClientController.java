package com.yash.builder_portfolio_management_springboot.controller;

import com.yash.builder_portfolio_management_springboot.entity.Address;
import com.yash.builder_portfolio_management_springboot.entity.Client;
import com.yash.builder_portfolio_management_springboot.entity.User;
import com.yash.builder_portfolio_management_springboot.enums.ClientType;
import com.yash.builder_portfolio_management_springboot.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public void createClient(@RequestBody Client client) {
        clientService.createClient(
                client.getClientEmailId(),
                client.getClientName(),
                client.getClientType(),
                client.getAddress(),
                client.getPhoneNumber(),
                client.getUser()
        );
    }

    @PutMapping("/{clientEmailId}")
    public void updateClient(
            @PathVariable String clientEmailId,
            @RequestBody Client updatedClient
    ) {
        clientService.updateClient(
                clientEmailId,
                updatedClient.getClientName(),
                updatedClient.getClientType(),
                updatedClient.getAddress(),
                updatedClient.getPhoneNumber()
        );
    }

    @DeleteMapping("/{clientEmailId}")
    public void deleteClient(@PathVariable String clientEmailId) {
        clientService.deleteClient(clientEmailId);
    }

    @GetMapping("/{clientEmailId}")
    public Client getClientDetails(@PathVariable String clientEmailId) {
        return clientService.getClientDetails(clientEmailId);
    }
}

