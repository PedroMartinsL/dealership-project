package com.dealership.project.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dealership.project.domain.entities.offers.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
    
}
