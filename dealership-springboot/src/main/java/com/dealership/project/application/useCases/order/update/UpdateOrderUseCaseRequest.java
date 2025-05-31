package com.dealership.project.application.useCases.order.update;

import com.dealership.project.api.dto.OrderDTO;

public record UpdateOrderUseCaseRequest(Long id, OrderDTO orderDTO) {
}
