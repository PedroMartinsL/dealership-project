package com.dealership.project.application.useCases.getCar;

import java.util.Optional;

import com.dealership.project.domain.entities.offers.Car;

public record GetCarUseCaseResponse(Optional<Car> car) {
}
