package com.dealership.project.application.useCases.customization;

import org.springframework.beans.factory.annotation.Autowired;

import com.dealership.project.infrastructure.repositories.JpaCustomizationRepository;

public abstract class AbstractCustomizationUseCase {
    @Autowired
    protected JpaCustomizationRepository customizationRepository;
}

