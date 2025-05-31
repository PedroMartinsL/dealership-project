package com.dealership.project.application.useCases.order.delete;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.order.AbstractOrderUseCase;
import com.dealership.project.presentation.exceptions.DatabaseException;
import com.dealership.project.presentation.exceptions.ResourceNotFoundException;

@Service
public class DeleteOrderUseCase extends AbstractOrderUseCase {

    public void execute(DeleteOrderUseCaseRequest request) {
        Long id = request.id();
        try {
			orderRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); //Passando exception da própria camada de serviço
		}
    }
}
