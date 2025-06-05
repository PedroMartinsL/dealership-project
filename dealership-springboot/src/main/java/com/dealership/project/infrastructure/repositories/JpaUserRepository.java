package com.dealership.project.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dealership.project.domain.entities.User;

public interface JpaUserRepository extends JpaRepository<User, String> {
    
    @Query("SELECT u FROM User u WHERE u.props.email = :email")
    Optional<User> findByEmail(@Param("email") String email);
}

