package com.dealership.project.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dealership.project.domain.entities.UserMain;

public interface JpaUserRepository extends JpaRepository<UserMain, String> {
    
    @Query("SELECT u FROM UserMain u WHERE u.props.name = :name")
    Optional<UserMain> findByName(@Param("name") String name);
}

