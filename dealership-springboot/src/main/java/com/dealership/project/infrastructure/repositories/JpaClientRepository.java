package com.dealership.project.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dealership.project.domain.entities.Client;

public interface JpaClientRepository extends JpaRepository<Client, UUID> {
    Client findByClientId(String clientId);
}
