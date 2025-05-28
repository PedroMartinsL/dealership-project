package com.dealership.project.application.useCases.order.sendOrder;

import com.dealership.project.domain.entities.offers.Car;
import com.dealership.project.domain.entities.offers.Customization;

public record SendOrderUseCaseRequest(
  Car car,
  Customization customization
) {
}