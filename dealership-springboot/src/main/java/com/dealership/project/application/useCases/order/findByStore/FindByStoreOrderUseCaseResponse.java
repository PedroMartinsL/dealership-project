package com.dealership.project.application.useCases.order.findByStore;

import java.util.List;

import com.dealership.project.domain.entities.Order;

public record FindByStoreOrderUseCaseResponse(List<Order> orders) {
}
