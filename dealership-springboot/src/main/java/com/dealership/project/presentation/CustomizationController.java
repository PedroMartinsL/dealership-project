package com.dealership.project.presentation;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dealership.project.api.dto.OrderDTO;
import com.dealership.project.application.useCases.car.findAll.ListCarsUseCase;
import com.dealership.project.application.useCases.car.findAll.ListCarsUseCaseResponse;
import com.dealership.project.application.useCases.car.findById.GetCarUseCase;
import com.dealership.project.application.useCases.car.findById.GetCarUseCaseRequest;
import com.dealership.project.application.useCases.car.findById.GetCarUseCaseResponse;
import com.dealership.project.application.useCases.order.delete.DeleteOrderUseCaseRequest;
import com.dealership.project.application.useCases.order.send.SendOrderUseCaseRequest;
import com.dealership.project.application.useCases.order.send.SendOrderUseCaseResponse;
import com.dealership.project.application.useCases.order.update.UpdateOrderUseCaseRequest;
import com.dealership.project.application.useCases.order.update.UpdateOrderUseCaseResponse;
import com.dealership.project.domain.entities.Customization;
import com.dealership.project.domain.entities.Order;

@Controller
@RequestMapping(value = "/customizations")
public class CustomizationController {

    @Autowired
    private SendCustomizationUseCase sendCustomizationUseCase;

    @Autowired
    private FindByIdCustomizationUseCase findByIdCustomizationUseCase;

    @Autowired
    private FindAllCustomizationsUseCase findAllCustomizationsUseCase;

    @GetMapping
    public ResponseEntity<List<Customization>> findAll() {
		FindAllCustomizationsUseCaseResponse response = findAllCustomizationsUseCase.execute();
        List<Customization> CustomizationsList = response.Customizations();
		return ResponseEntity.ok().body(CustomizationsList);
	}

    @GetMapping("/{id}")
    public ResponseEntity<Customization> findById(@PathVariable Long id) {
		FindByIdCustomizationUseCaseRequest CustomizationRequest = new FindByIdCustomizationUseCaseRequest(id);
        FindByIdCustomizationUseCaseResponse CustomizationReponse = findByIdCustomizationUseCase.execute(CustomizationRequest);
        Customization Customization = CustomizationReponse.Customization();
		return ResponseEntity.ok().body(Customization);
	}

    @PostMapping
    public ResponseEntity<Customization> insert(
        @RequestBody CustomizationDTO CustomizationDTO
    ) {
        SendCustomizationUseCaseRequest CustomizationRequest = new SendCustomizationUseCaseRequest(CustomizationDTO);
        SendCustomizationUseCaseResponse CustomizationResponse = sendCustomizationUseCase.execute(CustomizationRequest);
        Customization Customization = CustomizationResponse.Customization();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Customization.getId()).toUri();
		return ResponseEntity.created(uri).body(Customization);
    }
}
