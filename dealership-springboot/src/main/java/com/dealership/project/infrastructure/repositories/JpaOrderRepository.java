package com.dealership.project.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dealership.project.domain.entities.Order;


public interface JpaOrderRepository extends JpaRepository<Order, Long>{

    List<Order> findByStoreId(Long storeId);

    boolean existsByStoreId(Long storeId);
    
    boolean existsByCarId(Long carId);

    @Query("SELECT o FROM Order o WHERE o.user.props.email = :email")
    List<Order> findByUserEmail(@Param("email") String email);

}
