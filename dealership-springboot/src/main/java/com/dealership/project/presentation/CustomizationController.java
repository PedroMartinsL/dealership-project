package com.dealership.project.presentation;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dealership.project.api.dto.CustomizationDTO;
import com.dealership.project.application.useCases.customization.findAll.FindAllCustomizationsUseCase;
import com.dealership.project.application.useCases.customization.findAll.FindAllCustomizationsUseCaseResponse;
import com.dealership.project.application.useCases.customization.findById.FindByIdCustomizationUseCase;
import com.dealership.project.application.useCases.customization.findById.FindByIdCustomizationUseCaseRequest;
import com.dealership.project.application.useCases.customization.findById.FindByIdCustomizationUseCaseResponse;
import com.dealership.project.application.useCases.customization.send.SendCustomizationUseCase;
import com.dealership.project.application.useCases.customization.send.SendCustomizationUseCaseRequest;
import com.dealership.project.application.useCases.customization.send.SendCustomizationUseCaseResponse;
import com.dealership.project.domain.entities.Customization;

@RestController
@RequestMapping("/customizations")
public class CustomizationController {

    @Autowired
    private SendCustomizationUseCase sendCustomizationUseCase;

    @Autowired
    private FindByIdCustomizationUseCase findByIdCustomizationUseCase;

    @Autowired
    private FindAllCustomizationsUseCase findAllCustomizationsUseCase;

    @GetMapping
    @PreAuthorize("hasAnyRole('CLIENT', 'ADMIN')")
    public ResponseEntity<List<Customization>> findAll() {
		FindAllCustomizationsUseCaseResponse response = findAllCustomizationsUseCase.execute();
        List<Customization> customizationsList = response.customizations();
		return ResponseEntity.ok().body(customizationsList);
	}

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('CLIENT', 'ADMIN')")
    public ResponseEntity<Customization> findById(@PathVariable Long id) {
		FindByIdCustomizationUseCaseRequest customizationRequest = new FindByIdCustomizationUseCaseRequest(id);
        FindByIdCustomizationUseCaseResponse customizationReponse = findByIdCustomizationUseCase.execute(customizationRequest);
        Customization customization = customizationReponse.customization();
		return ResponseEntity.ok().body(customization);
	}

    @PostMapping
    @PreAuthorize("hasAnyRole('CLIENT', 'ADMIN')")
    public ResponseEntity<Customization> insert(
        @RequestBody CustomizationDTO customizationDTO
    ) {
        SendCustomizationUseCaseRequest customizationRequest = new SendCustomizationUseCaseRequest(customizationDTO);
        SendCustomizationUseCaseResponse customizationResponse = sendCustomizationUseCase.execute(customizationRequest);
        Customization customization = customizationResponse.customization();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customization.getId()).toUri();
		return ResponseEntity.created(uri).body(customization);
    }
}
