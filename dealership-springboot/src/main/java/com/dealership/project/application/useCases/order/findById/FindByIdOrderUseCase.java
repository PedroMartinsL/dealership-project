package com.dealership.project.application.useCases.order.findById;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.order.AbstractOrderUseCase;
import com.dealership.project.domain.entities.Order;
import com.dealership.project.presentation.exceptions.ResourceNotFoundException;

@Service
public class FindByIdOrderUseCase extends AbstractOrderUseCase {

  public FindByIdOrderUseCaseResponse execute(FindByIdOrderUseCaseRequest request) {
    Long id = request.orderId();
    Order order = orderRepository.findById(id)
                                 .orElseThrow(() -> new ResourceNotFoundException(id));
    return new FindByIdOrderUseCaseResponse(order);
  }
}