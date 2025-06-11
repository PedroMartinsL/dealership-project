package com.dealership.project.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dealership.project.domain.entities.Customization;

public interface JpaCustomizationRepository extends JpaRepository<Customization, Long> {
    
    @Query("SELECT o FROM Order o WHERE o.user.props.email = :email")
    List<Customization> findByUserEmail(@Param("email") String email);

}
