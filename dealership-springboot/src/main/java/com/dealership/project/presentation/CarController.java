package com.dealership.project.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dealership.project.application.useCases.car.getCar.GetCarUseCase;
import com.dealership.project.application.useCases.car.getCar.GetCarUseCaseRequest;
import com.dealership.project.application.useCases.car.getCar.GetCarUseCaseResponse;
import com.dealership.project.application.useCases.car.listCars.ListCarsUseCase;
import com.dealership.project.application.useCases.car.listCars.ListCarsUseCaseResponse;

@Controller
public class CarController {

    @Autowired
	private ListCarsUseCase listCarsUseCase;

    @Autowired
    private GetCarUseCase getCarUseCase;
    
    @GetMapping
	public ResponseEntity<ListCarsUseCaseResponse> findAll() {
		ListCarsUseCaseResponse response = listCarsUseCase.execute();
		return ResponseEntity.ok().body(response);
	}

    @GetMapping(value = "/{id}")
	public ResponseEntity<GetCarUseCaseResponse> findById(@PathVariable Long id) {
		GetCarUseCaseRequest getCarUseCaseRequest = new GetCarUseCaseRequest(id);
		GetCarUseCaseResponse response = getCarUseCase.execute(getCarUseCaseRequest);
		return ResponseEntity.ok().body(response);
	}
}
