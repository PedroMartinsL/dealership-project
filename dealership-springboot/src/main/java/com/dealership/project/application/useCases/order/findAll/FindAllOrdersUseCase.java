package com.dealership.project.application.useCases.order.findAll;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.order.AbstractOrderUseCase;
import com.dealership.project.domain.entities.Order;

@Service
public class FindAllOrdersUseCase extends AbstractOrderUseCase {

  public FindAllOrdersUseCaseResponse execute() {
    List<Order> orders;

    if (securityService.isAdmin()) {
        orders = orderRepository.findAll();
    } else {
        String userEmail = securityService.getUserEmail();
        orders = orderRepository.findByUserEmail(userEmail);
    }

    return new FindAllOrdersUseCaseResponse(orders);
  }
}