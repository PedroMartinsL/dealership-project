package com.dealership.project.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dealership.project.domain.entities.offers.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
