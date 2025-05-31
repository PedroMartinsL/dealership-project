package com.dealership.project.application.useCases.order.findById;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.order.AbstractOrderUseCase;
import com.dealership.project.domain.entities.Order;

import jakarta.transaction.Transactional;

@Service
public class FindByIdOrderUseCase extends AbstractOrderUseCase {

  @Transactional
  public FindByIdOrderUseCaseResponse execute(FindByIdOrderUseCaseRequest request) {
    Order order = orderRepository.findById(request.orderId())
                                 .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    return new FindByIdOrderUseCaseResponse(order);
  }
}