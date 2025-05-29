package com.dealership.project.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dealership.project.domain.entities.Customization;

public interface JpaCustomizationRepository extends JpaRepository<Customization, Long> {

}
