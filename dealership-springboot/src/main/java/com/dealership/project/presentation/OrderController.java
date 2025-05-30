package com.dealership.project.presentation;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dealership.project.api.dto.OrderDTO;
import com.dealership.project.application.useCases.order.findAll.FindAllOrdersUseCase;
import com.dealership.project.application.useCases.order.findAll.FindAllOrdersUseCaseResponse;
import com.dealership.project.application.useCases.order.findById.FindByIdOrderUseCase;
import com.dealership.project.application.useCases.order.findById.FindByIdOrderUseCaseRequest;
import com.dealership.project.application.useCases.order.findById.FindByIdOrderUseCaseResponse;
import com.dealership.project.application.useCases.order.sendOrder.SendOrderUseCase;
import com.dealership.project.application.useCases.order.sendOrder.SendOrderUseCaseRequest;
import com.dealership.project.application.useCases.order.sendOrder.SendOrderUseCaseResponse;
import com.dealership.project.domain.entities.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private SendOrderUseCase sendOrderUseCase;

    @Autowired
    private FindByIdOrderUseCase findByIdOrderUseCase;

    @Autowired
    private FindAllOrdersUseCase findAllOrdersUseCase;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
		FindAllOrdersUseCaseResponse response = findAllOrdersUseCase.execute();
        List<Order> ordersList = response.orders();
		return ResponseEntity.ok().body(ordersList);
	}

    @GetMapping("/id")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
		FindByIdOrderUseCaseRequest orderRequest = new FindByIdOrderUseCaseRequest(id);
        FindByIdOrderUseCaseResponse orderReponse = findByIdOrderUseCase.execute(orderRequest);
        Order order = orderReponse.order();
		return ResponseEntity.ok().body(order);
	}

    @PostMapping
    public ResponseEntity<Order> insert(
        @RequestBody OrderDTO orderDTO
    ) {
        SendOrderUseCaseRequest orderRequest = new SendOrderUseCaseRequest(orderDTO);
        SendOrderUseCaseResponse orderResponse = sendOrderUseCase.execute(orderRequest);
        Order order = orderResponse.order();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(order.getId()).toUri();
		return ResponseEntity.created(uri).body(order);
    }


}
