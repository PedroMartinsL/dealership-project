package com.dealership.project.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dealership.project.domain.entities.Car;

public interface JpaCarRepository extends JpaRepository<Car, Long> {
}
