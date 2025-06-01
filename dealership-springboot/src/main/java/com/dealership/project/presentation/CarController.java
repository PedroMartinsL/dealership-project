package com.dealership.project.presentation;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dealership.project.application.useCases.car.findAll.FindAllCarsUseCase;
import com.dealership.project.application.useCases.car.findAll.FindAllCarsUseCaseResponse;
import com.dealership.project.application.useCases.car.findById.FindByIdCarUseCase;
import com.dealership.project.application.useCases.car.findById.FindByIdCarUseCaseRequest;
import com.dealership.project.application.useCases.car.findById.FindByIdCarUseCaseResponse;
import com.dealership.project.domain.entities.Car;

@Controller
@RequestMapping(value = "/cars")
public class CarController {
	
	@Autowired
    private SendCarUseCase sendCarUseCase;

    @Autowired
    private FindByIdCarUseCase findByIdCarUseCase;

    @Autowired
    private FindAllCarsUseCase findAllCarsUseCase;

    @Autowired
    private UpdateCarUseCase updateCarUseCase;

    @GetMapping
    public ResponseEntity<List<Car>> findAll() {
		FindAllCarsUseCaseResponse response = findAllCarsUseCase.execute();
        List<Car> CarsList = response.Cars();
		return ResponseEntity.ok().body(CarsList);
	}

    @GetMapping("/{id}")
    public ResponseEntity<Car> findById(@PathVariable Long id) {
		FindByIdCarUseCaseRequest CarRequest = new FindByIdCarUseCaseRequest(id);
        FindByIdCarUseCaseResponse CarReponse = findByIdCarUseCase.execute(CarRequest);
        Car Car = CarReponse.Car();
		return ResponseEntity.ok().body(Car);
	}

    @PostMapping
    public ResponseEntity<Car> insert(
        @RequestBody CarDTO CarDTO
    ) {
        SendCarUseCaseRequest CarRequest = new SendCarUseCaseRequest(CarDTO);
        SendCarUseCaseResponse CarResponse = sendCarUseCase.execute(CarRequest);
        Car Car = CarResponse.Car();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Car.getId()).toUri();
		return ResponseEntity.created(uri).body(Car);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> update(@PathVariable Long id, @RequestBody CarDTO CarDTO) {
        UpdateCarUseCaseRequest request = new UpdateCarUseCaseRequest(id, CarDTO);
		UpdateCarUseCaseResponse response = updateCarUseCase.execute(request);
        Car Car = response.Car();
		return ResponseEntity.ok().body(Car);
	}
}
