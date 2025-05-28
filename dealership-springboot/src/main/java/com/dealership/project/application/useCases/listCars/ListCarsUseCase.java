package com.dealership.project.application.useCases.listCars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealership.project.infrastructure.repositories.CarRepository;

@Service
public class ListCarsUseCase {

    @Autowired
    private CarRepository repository;

    public ListCarsUseCaseResponse execute() {
        return new ListCarsUseCaseResponse(repository.findAll());
    }
}
