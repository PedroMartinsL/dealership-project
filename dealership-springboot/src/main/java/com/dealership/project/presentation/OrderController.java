package com.dealership.project.presentation;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dealership.project.api.dto.OrderDTO;
import com.dealership.project.application.useCases.order.OrderUseCaseRequest;
import com.dealership.project.application.useCases.order.OrderUseCaseResponse;
import com.dealership.project.application.useCases.order.sendOrder.SendOrderUseCase;
import com.dealership.project.domain.entities.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private SendOrderUseCase sendOrderUseCase;

    // @Autowired
    // private GetOrderUseCase getOrderUseCase;

    // @Autowired
    // private GetOrderByIdUseCase getOrderByIdUseCase;

    // @GetMapping
    // public ResponseEntity<ListCarsUseCaseResponse> findAll() {
	// 	ListCarsUseCaseResponse response = getOrderUseCase.execute();
	// 	return ResponseEntity.ok().body(response);
	// }

    // @GetMapping("/id")
    // public ResponseEntity<GetCarUseCaseResponse> findById(@PathVariable Long id) {
	// 	GetCarUseCaseRequest getCarUseCaseRequest = new GetCarUseCaseRequest(id);
	// 	GetCarUseCaseResponse response = getOrderByIdUseCase.execute(getCarUseCaseRequest);
	// 	return ResponseEntity.ok().body(response);
	// }

    @PostMapping
    public ResponseEntity<Order> insert(
        @RequestBody OrderDTO orderDTO
    ) {
        Order order = new Order(orderDTO);
        OrderUseCaseRequest orderRequest = new OrderUseCaseRequest(order);
        OrderUseCaseResponse orderResponse = sendOrderUseCase.execute(orderRequest);
        order = orderResponse.order();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(order.getId()).toUri();
		return ResponseEntity.created(uri).body(order);
    }


}
