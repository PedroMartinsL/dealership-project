package com.dealership.project.application.useCases.order.send;

import com.dealership.project.domain.entities.Order;

public record SendOrderUseCaseResponse (
  Order order
) {
}