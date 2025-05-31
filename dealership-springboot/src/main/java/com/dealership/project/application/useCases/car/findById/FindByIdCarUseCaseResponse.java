package com.dealership.project.application.useCases.car.findById;

import java.util.Optional;

import com.dealership.project.domain.entities.Car;

public record FindByIdCarUseCaseResponse(Optional<Car> car) {
}
