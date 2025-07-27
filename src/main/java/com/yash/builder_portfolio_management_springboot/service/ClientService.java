package com.yash.builder_portfolio_management_springboot.service;

import com.yash.builder_portfolio_management_springboot.entity.Address;
import com.yash.builder_portfolio_management_springboot.entity.Client;
import com.yash.builder_portfolio_management_springboot.entity.User;
import com.yash.builder_portfolio_management_springboot.enums.ClientType;
import com.yash.builder_portfolio_management_springboot.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void createClient(String clientEmailId, String clientName, ClientType clientType, Address address, String phoneNumber) {
        Client client = Client.builder()
                .clientEmailId(clientEmailId)
                .clientName(clientName)
                .clientType(clientType)
                .address(address)
                .phoneNumber(phoneNumber)
                .build();
        clientRepository.save(client);
    }

    public void updateClient(String clientEmailId, String newClientName, ClientType newClientType, Address newAddress, String newPhoneNumber) {
        Optional<Client> optionalClient = clientRepository.findById(clientEmailId);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.setClientName(newClientName);
            client.setClientType(newClientType);
            client.setAddress(newAddress);
            client.setPhoneNumber(newPhoneNumber);
            clientRepository.save(client);
        } else {
            throw new RuntimeException("Client with email " + clientEmailId + " not found.");
        }
    }

    public void deleteClient(String clientEmailId) {
        if (clientRepository.existsById(clientEmailId)) {
            clientRepository.deleteById(clientEmailId);
        } else {
            throw new RuntimeException("Client with email " + clientEmailId + " not found.");
        }
    }

    public Client getClientDetails(String clientEmailId) {
        return clientRepository.findById(clientEmailId)
                .orElseThrow(() -> new RuntimeException("Client with email " + clientEmailId + " not found."));
    }
}