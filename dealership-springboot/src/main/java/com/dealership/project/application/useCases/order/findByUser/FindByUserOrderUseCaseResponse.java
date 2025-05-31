package com.dealership.project.application.useCases.order.findByUser;

import java.util.List;

import com.dealership.project.domain.entities.Order;

public record  FindByUserOrderUseCaseResponse(List<Order> orders) {
}
