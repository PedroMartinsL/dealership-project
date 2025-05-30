package com.dealership.project.application.useCases.order.findById;

import com.dealership.project.domain.entities.Order;

public record FindByIdOrderUseCaseResponse (
  Order order
) {
}