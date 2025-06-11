package com.dealership.project.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dealership.project.domain.entities.Customization;

public interface JpaCustomizationRepository extends JpaRepository<Customization, Long> {
    List<Customization> findByUserEmail(String email);
}
