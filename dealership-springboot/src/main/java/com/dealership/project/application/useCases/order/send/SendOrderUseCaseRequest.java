package com.dealership.project.application.useCases.order.send;

import com.dealership.project.api.dto.OrderDTO;

public record SendOrderUseCaseRequest(
  OrderDTO orderDTO
) {
}