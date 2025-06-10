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
        String senhaCriptografada = encoder.encode(client.getClientSecret());
        client.setClientSecret(senhaCriptografada);
        return clientReposository.save(client);
    }

    public Client getByClientID(String clientId) {
        return clientReposository.findByClientId(clientId);
    }
}
