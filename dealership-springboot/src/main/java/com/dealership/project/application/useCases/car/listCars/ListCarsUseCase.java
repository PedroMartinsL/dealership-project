package com.dealership.project.application.useCases.car.listCars;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealership.project.domain.entities.offers.Car;
import com.dealership.project.infrastructure.repositories.JpaCarRepository;

@Service
public class ListCarsUseCase {

    @Autowired
    private JpaCarRepository carRepository;

    public ListCarsUseCaseResponse execute() {
        List<Car> listCars = carRepository.findAll();
        return new ListCarsUseCaseResponse(listCars);
    }
}
