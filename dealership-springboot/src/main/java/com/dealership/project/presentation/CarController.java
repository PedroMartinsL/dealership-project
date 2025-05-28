package com.dealership.project.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dealership.project.application.useCases.getCar.GetCarUseCase;
import com.dealership.project.application.useCases.getCar.GetCarUseCaseRequest;
import com.dealership.project.application.useCases.getCar.GetCarUseCaseResponse;
import com.dealership.project.application.useCases.listCars.ListCarsUseCase;
import com.dealership.project.application.useCases.listCars.ListCarsUseCaseResponse;

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
		GetCarUseCaseResponse response = getCarUseCase.execute(new GetCarUseCaseRequest(id));
		return ResponseEntity.ok().body(response);
	}
}
