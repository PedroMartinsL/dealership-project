package com.dealership.project.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dealership.project.domain.entities.offers.Customization;

public interface CustomizationRepository extends JpaRepository<Customization, Long> {

}
