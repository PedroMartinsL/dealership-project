package com.dealership.project.application.useCases.car.findAll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealership.project.domain.entities.Car;
import com.dealership.project.infrastructure.repositories.JpaCarRepository;

@Service
public class FindAllCarsUseCase {

    @Autowired
    private JpaCarRepository carRepository;

    public FindAllCarsUseCaseResponse execute() {
        List<Car> listCars = carRepository.findAll();
        return new FindAllCarsUseCaseResponse(listCars);
    }
}
