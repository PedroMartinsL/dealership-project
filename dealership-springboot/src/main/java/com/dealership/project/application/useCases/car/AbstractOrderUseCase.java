package com.dealership.project.application.useCases.car;

import org.springframework.beans.factory.annotation.Autowired;

import com.dealership.project.infrastructure.repositories.JpaCarRepository;

public abstract class AbstractOrderUseCase {
    @Autowired
    protected JpaCarRepository carRepository;
}

