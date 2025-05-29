package com.dealership.project.application.useCases.car.getCar;

import java.util.Optional;

import com.dealership.project.domain.entities.Car;

public record GetCarUseCaseResponse(Optional<Car> car) {
}
