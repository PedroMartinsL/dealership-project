package com.dealership.project.application.useCases.engine;

import org.springframework.beans.factory.annotation.Autowired;

import com.dealership.project.infrastructure.repositories.JpaEngineRepository;

public abstract class AbstractEngineUseCase {
    @Autowired
    protected JpaEngineRepository engineRepository;
}

