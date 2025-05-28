package com.dealership.project.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dealership.project.domain.entities.offers.Engine;

public interface JpaEngineRepository extends JpaRepository<Engine, Long>{

}
