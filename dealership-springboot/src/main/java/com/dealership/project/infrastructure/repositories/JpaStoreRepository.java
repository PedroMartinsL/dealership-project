package com.dealership.project.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dealership.project.domain.entities.Store;

public interface JpaStoreRepository extends JpaRepository<Store, Long> {
    
}
