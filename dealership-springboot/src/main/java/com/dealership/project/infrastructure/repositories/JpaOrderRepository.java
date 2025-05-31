package com.dealership.project.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dealership.project.domain.entities.Order;


public interface JpaOrderRepository extends JpaRepository<Order, Long>{
    List<Order> findByStoreId(Long storeId);
    List<Order> findByUserId(Long userId);
}
