package com.dealership.project.application.useCases.store;

import org.springframework.beans.factory.annotation.Autowired;

import com.dealership.project.infrastructure.repositories.JpaStoreRepository;

public abstract class AbstractStoreUseCase {
    @Autowired
    protected JpaStoreRepository storeRepository;
}

