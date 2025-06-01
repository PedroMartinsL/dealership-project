package com.dealership.project.application.useCases.car.send;

import com.dealership.project.domain.entities.Car;

public record SendCarUseCaseResponse (
  Car car
) {
}