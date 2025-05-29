package com.dealership.project.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dealership.project.domain.entities.Order;

public interface JpaOrderRepository extends JpaRepository<Order, Long>{
    
}
