package com.dealership.project.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dealership.project.domain.entities.User;

public interface JpaUserRepository extends JpaRepository<User, String> {
    
}
