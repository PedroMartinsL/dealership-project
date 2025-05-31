package com.dealership.project.application.useCases.order;

import org.springframework.beans.factory.annotation.Autowired;

import com.dealership.project.infrastructure.repositories.JpaOrderRepository;

public abstract class AbstractOrderUseCase {
    @Autowired
    protected JpaOrderRepository orderRepository;
}

