package com.dealership.project.application.useCases.order.sendOrder;

import com.dealership.project.domain.entities.Car;
import com.dealership.project.domain.entities.Customization;

public record SendOrderUseCaseResponse (
  Car car,
  Customization customization
) {
}