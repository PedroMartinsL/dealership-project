package com.dealership.project.application.useCases.order.findById;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealership.project.domain.entities.Order;
import com.dealership.project.infrastructure.repositories.JpaOrderRepository;

import jakarta.transaction.Transactional;

@Service
public class FindByIdOrderUseCase {

  @Autowired
  private JpaOrderRepository orderRepository;

  @Transactional
  public FindByIdOrderUseCaseResponse execute(FindByIdOrderUseCaseRequest request) {
    Order order = orderRepository.findById(request.orderId())
                                 .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    return new FindByIdOrderUseCaseResponse(order);
  }
}