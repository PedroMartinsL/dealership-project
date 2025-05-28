package com.dealership.project.application.useCases.order.sendOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealership.project.infrastructure.repositories.JpaOrderRepository;

import jakarta.transaction.Transactional;

@Service
public class SendOrderUseCase {

  @Autowired
  private JpaOrderRepository orderRepository;

  @Transactional
  public SendOrderUseCaseResponse execute(SendOrderUseCaseRequest data) {
    
    // Order order = new Order(data.car(), data.customization());

    // repository.save(order);

    return new SendOrderUseCaseResponse(data.car(),
            data.customization());    
  }
}