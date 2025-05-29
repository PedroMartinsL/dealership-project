package com.dealership.project.application.useCases.order.sendOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.order.OrderUseCaseRequest;
import com.dealership.project.application.useCases.order.OrderUseCaseResponse;
import com.dealership.project.domain.entities.Order;
import com.dealership.project.infrastructure.repositories.JpaOrderRepository;

import jakarta.transaction.Transactional;

@Service
public class SendOrderUseCase {

  @Autowired
  private JpaOrderRepository orderRepository;

  @Transactional
  public OrderUseCaseResponse execute(OrderUseCaseRequest request) {
    Order order = request.order();
    orderRepository.save(order);
    return new OrderUseCaseResponse();
  }
}