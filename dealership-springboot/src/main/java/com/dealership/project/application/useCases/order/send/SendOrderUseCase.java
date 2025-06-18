package com.dealership.project.application.useCases.order.send;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.order.AbstractOrderUseCase;
import com.dealership.project.domain.entities.Order;
import com.dealership.project.domain.entities.UserMain;

import jakarta.transaction.Transactional;

@Service
public class SendOrderUseCase extends AbstractOrderUseCase {

    @Transactional
    public SendOrderUseCaseResponse execute(SendOrderUseCaseRequest request) {
        try {
            UserMain user = securityService.getUserLogged();

            Order order = new Order(request.orderDTO());
            order.setUser(user);
            order = orderRepository.save(order);


            return new SendOrderUseCaseResponse(order);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao salvar pedido: " + e.getMessage(), e);
        }
    }
}
