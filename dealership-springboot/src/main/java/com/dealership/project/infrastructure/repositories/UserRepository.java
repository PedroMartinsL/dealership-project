package com.dealership.project.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dealership.project.domain.entities.users.User;

public interface UserRepository extends JpaRepository<User, String> {
    
}
