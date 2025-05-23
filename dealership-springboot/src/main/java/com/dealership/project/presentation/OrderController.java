package com.dealership.project.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dealership.project.application.useCases.sendOrder.SendOrderUseCase;
import com.dealership.project.application.useCases.sendOrder.SendOrderUseCaseRequest;
import com.dealership.project.application.useCases.sendOrder.SendOrderUseCaseResponse;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final SendOrderUseCase sendOrderUseCase;

    public OrderController(SendOrderUseCase sendOrderUseCase) {
        this.sendOrderUseCase = sendOrderUseCase;
    }

    @PostMapping
    public ResponseEntity<SendOrderUseCaseResponse> SendOrderUse(
        @RequestBody SendOrderUseCaseRequest request
    ) {
        SendOrderUseCaseResponse response = sendOrderUseCase.execute(request);
        return ResponseEntity.ok(response);
    }
}
