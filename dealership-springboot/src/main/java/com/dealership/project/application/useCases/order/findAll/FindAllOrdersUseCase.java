package com.dealership.project.application.useCases.order.findAll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealership.project.domain.entities.Order;
import com.dealership.project.infrastructure.repositories.JpaOrderRepository;

import jakarta.transaction.Transactional;

@Service
public class FindAllOrdersUseCase {

  @Autowired
  private JpaOrderRepository orderRepository;

  @Transactional
  public FindAllOrdersUseCaseResponse execute() {
    List<Order> orders = orderRepository.findAll();
    return new FindAllOrdersUseCaseResponse(orders);
  }
}