package com.dealership.project.application.useCases.order.send;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.order.AbstractOrderUseCase;
import com.dealership.project.domain.entities.Order;

import jakarta.transaction.Transactional;

@Service
public class SendOrderUseCase extends AbstractOrderUseCase {

  @Transactional
  public SendOrderUseCaseResponse execute(SendOrderUseCaseRequest request) {
    Order order = new Order(request.orderDTO());
    order = orderRepository.save(order);
    return new SendOrderUseCaseResponse(order);
  }
}