package com.dealership.project.application.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dealership.project.domain.entities.Client;
import com.dealership.project.infrastructure.repositories.JpaClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {
    
    private final JpaClientRepository clientReposository;
    private final PasswordEncoder encoder;

    public Client save(Client client){
        try {
            String senhaCriptografada = encoder.encode(client.getClientSecret());
            client.setClientSecret(senhaCriptografada);
            return clientReposository.save(client);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving client: " + e.getMessage(), e);
        }
    }

    public Client getByClientID(String clientId) {
        try {
            return clientReposository.findByClientId(clientId);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error getting client: " + e.getMessage(), e);
        }
    }
}
