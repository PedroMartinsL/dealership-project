package com.dealership.project.application.useCases.order.sendOrder;

import com.dealership.project.domain.entities.Order;

public record SendOrderUseCaseResponse (
  Order order
) {
}