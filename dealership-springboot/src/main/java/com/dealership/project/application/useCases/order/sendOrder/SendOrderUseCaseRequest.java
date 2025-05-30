package com.dealership.project.application.useCases.order.sendOrder;

import com.dealership.project.api.dto.OrderDTO;

public record SendOrderUseCaseRequest(
  OrderDTO orderDTO
) {
}