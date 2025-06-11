package com.dealership.project.application.useCases.order.findById;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.order.AbstractOrderUseCase;
import com.dealership.project.domain.entities.Order;
import com.dealership.project.presentation.exceptions.ResourceNotFoundException;

@Service
public class FindByIdOrderUseCase extends AbstractOrderUseCase {

  public FindByIdOrderUseCaseResponse execute(FindByIdOrderUseCaseRequest request) {
    Long id = request.orderId();

    List<Order> orders;

    if (securityService.isAdmin()) {
        orders = orderRepository.findAll();
    } else {
        String email = securityService.getUserEmail(); 
        orders = orderRepository.findByUserEmail(email);
    }
    // Verifica se algum pedido com o ID fornecido existe
    Order order = orders.stream()
                        .filter(o -> o.getId().equals(id))
                        .findFirst()
                        .orElseThrow(() -> new ResourceNotFoundException(id));

    return new FindByIdOrderUseCaseResponse(order);
  }
}