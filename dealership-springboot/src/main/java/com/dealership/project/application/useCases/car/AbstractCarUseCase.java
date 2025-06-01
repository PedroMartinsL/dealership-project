package com.dealership.project.application.useCases.car;

import org.springframework.beans.factory.annotation.Autowired;

import com.dealership.project.infrastructure.repositories.JpaCarRepository;

public abstract class AbstractCarUseCase {
    @Autowired
    protected JpaCarRepository carRepository;
}

