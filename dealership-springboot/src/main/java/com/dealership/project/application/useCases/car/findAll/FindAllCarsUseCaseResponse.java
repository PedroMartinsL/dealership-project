package com.dealership.project.application.useCases.car.findAll;

import java.util.List;

import com.dealership.project.domain.entities.Car;

public record FindAllCarsUseCaseResponse (List<Car> listCars) {
}