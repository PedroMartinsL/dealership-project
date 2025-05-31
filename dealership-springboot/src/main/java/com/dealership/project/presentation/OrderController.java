package com.dealership.project.presentation;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dealership.project.api.dto.OrderDTO;
import com.dealership.project.application.useCases.order.delete.DeleteOrderUseCase;
import com.dealership.project.application.useCases.order.delete.DeleteOrderUseCaseRequest;
import com.dealership.project.application.useCases.order.findAll.FindAllOrdersUseCase;
import com.dealership.project.application.useCases.order.findAll.FindAllOrdersUseCaseResponse;
import com.dealership.project.application.useCases.order.findById.FindByIdOrderUseCase;
import com.dealership.project.application.useCases.order.findById.FindByIdOrderUseCaseRequest;
import com.dealership.project.application.useCases.order.findById.FindByIdOrderUseCaseResponse;
import com.dealership.project.application.useCases.order.findByStore.FindByStoreOrderUseCase;
import com.dealership.project.application.useCases.order.findByStore.FindByStoreOrderUseCaseRequest;
import com.dealership.project.application.useCases.order.findByStore.FindByStoreOrderUseCaseResponse;
import com.dealership.project.application.useCases.order.findByUser.FindByUserOrderUseCase;
import com.dealership.project.application.useCases.order.findByUser.FindByUserOrderUseCaseRequest;
import com.dealership.project.application.useCases.order.findByUser.FindByUserOrderUseCaseResponse;
import com.dealership.project.application.useCases.order.send.SendOrderUseCase;
import com.dealership.project.application.useCases.order.send.SendOrderUseCaseRequest;
import com.dealership.project.application.useCases.order.send.SendOrderUseCaseResponse;
import com.dealership.project.application.useCases.order.update.UpdateOrderUseCase;
import com.dealership.project.application.useCases.order.update.UpdateOrderUseCaseRequest;
import com.dealership.project.application.useCases.order.update.UpdateOrderUseCaseResponse;
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

    @Autowired
    private DeleteOrderUseCase deleteOrderUseCase;

    @Autowired
    private UpdateOrderUseCase updateOrderUseCase;

    @Autowired
    private FindByStoreOrderUseCase findByStoreOrderUseCase;

    @Autowired
    private FindByUserOrderUseCase findByUserOrderUseCase;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
		FindAllOrdersUseCaseResponse response = findAllOrdersUseCase.execute();
        List<Order> ordersList = response.orders();
		return ResponseEntity.ok().body(ordersList);
	}

    @GetMapping("/{id}")
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

    @DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
        DeleteOrderUseCaseRequest request = new DeleteOrderUseCaseRequest(id);
		deleteOrderUseCase.execute(request);
		return ResponseEntity.noContent().build();
	}

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        UpdateOrderUseCaseRequest request = new UpdateOrderUseCaseRequest(id, orderDTO);
		UpdateOrderUseCaseResponse response = updateOrderUseCase.execute(request);
        Order order = response.order();
		return ResponseEntity.ok().body(order);
	}

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> findByUser(@PathVariable Long userId) {
        FindByUserOrderUseCaseRequest orderRequest = new FindByUserOrderUseCaseRequest(userId);
        FindByUserOrderUseCaseResponse orderReponse = findByUserOrderUseCase.execute(orderRequest);
        List<Order> orders = orderReponse.orders();
		return ResponseEntity.ok().body(orders);
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<List<Order>> findByStore(@PathVariable Long storeId) {
        FindByStoreOrderUseCaseRequest orderRequest = new FindByStoreOrderUseCaseRequest(storeId);
        FindByStoreOrderUseCaseResponse orderReponse = findByStoreOrderUseCase.execute(orderRequest);
        List<Order> orders = orderReponse.orders();
		return ResponseEntity.ok().body(orders);
    }
}
