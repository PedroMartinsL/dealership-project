package com.dealership.project.application.useCases.order.findAll;

import java.util.List;

import com.dealership.project.domain.entities.Order;

public record FindAllOrdersUseCaseResponse (
  List<Order> orders
) {
}