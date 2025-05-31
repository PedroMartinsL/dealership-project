package com.dealership.project.application.useCases.order.findAll;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.order.AbstractOrderUseCase;
import com.dealership.project.domain.entities.Order;

import jakarta.transaction.Transactional;

@Service
public class FindAllOrdersUseCase extends AbstractOrderUseCase {

  @Transactional
  public FindAllOrdersUseCaseResponse execute() {
    List<Order> orders = orderRepository.findAll();
    return new FindAllOrdersUseCaseResponse(orders);
  }
}