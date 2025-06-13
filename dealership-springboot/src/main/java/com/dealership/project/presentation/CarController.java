package com.dealership.project.presentation;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dealership.project.api.dto.CarDTO;
import com.dealership.project.application.useCases.car.delete.DeleteCarUseCase;
import com.dealership.project.application.useCases.car.delete.DeleteCarUseCaseRequest;
import com.dealership.project.application.useCases.car.findAll.FindAllCarsUseCase;
import com.dealership.project.application.useCases.car.findAll.FindAllCarsUseCaseResponse;
import com.dealership.project.application.useCases.car.findById.FindByIdCarUseCase;
import com.dealership.project.application.useCases.car.findById.FindByIdCarUseCaseRequest;
import com.dealership.project.application.useCases.car.findById.FindByIdCarUseCaseResponse;
import com.dealership.project.application.useCases.car.send.SendCarUseCase;
import com.dealership.project.application.useCases.car.send.SendCarUseCaseRequest;
import com.dealership.project.application.useCases.car.send.SendCarUseCaseResponse;
import com.dealership.project.application.useCases.car.update.UpdateCarUseCase;
import com.dealership.project.application.useCases.car.update.UpdateCarUseCaseRequest;
import com.dealership.project.application.useCases.car.update.UpdateCarUseCaseResponse;
import com.dealership.project.domain.entities.Car;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private FindByIdCarUseCase findByIdCarUseCase;

    @Autowired
    private FindAllCarsUseCase findAllCarsUseCase;

    @Autowired
    private UpdateCarUseCase updateCarUseCase;

    @Autowired
    private DeleteCarUseCase deleteCarUseCase;

    @Autowired
    private SendCarUseCase sendCarUseCase;

    @GetMapping
    public ResponseEntity<List<Car>> findAll() {
		FindAllCarsUseCaseResponse response = findAllCarsUseCase.execute();
        List<Car> CarsList = response.listCars();
		return ResponseEntity.ok().body(CarsList);
	}

    @GetMapping("/{id}")
    public ResponseEntity<Car> findById(@PathVariable Long id) {
		FindByIdCarUseCaseRequest carRequest = new FindByIdCarUseCaseRequest(id);
        FindByIdCarUseCaseResponse carReponse = findByIdCarUseCase.execute(carRequest);
        Car car = carReponse.car();
		return ResponseEntity.ok().body(car);
	}

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Car> insert(
        @RequestBody CarDTO carDTO
    ) {
        SendCarUseCaseRequest carRequest = new SendCarUseCaseRequest(carDTO);
        SendCarUseCaseResponse carResponse = sendCarUseCase.execute(carRequest);
        Car car = carResponse.car();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(car.getId()).toUri();
		return ResponseEntity.created(uri).body(car);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Car> update(@PathVariable Long id, @RequestBody CarDTO CarDTO) {
        UpdateCarUseCaseRequest request = new UpdateCarUseCaseRequest(id, CarDTO);
		UpdateCarUseCaseResponse response = updateCarUseCase.execute(request);
        Car Car = response.Car();
		return ResponseEntity.ok().body(Car);
	}

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
        DeleteCarUseCaseRequest request = new DeleteCarUseCaseRequest(id);
		deleteCarUseCase.execute(request);
		return ResponseEntity.noContent().build();
	}
}
