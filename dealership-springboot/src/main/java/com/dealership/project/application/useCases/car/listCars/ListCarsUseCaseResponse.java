package com.dealership.project.application.useCases.car.listCars;

import java.util.List;

import com.dealership.project.domain.entities.offers.Car;

public record ListCarsUseCaseResponse (List<Car> listCars) {
}