package com.dealership.project.application.useCases.order;

import com.dealership.project.domain.entities.Order;

public record OrderUseCaseRequest(
  Order order
) {
}