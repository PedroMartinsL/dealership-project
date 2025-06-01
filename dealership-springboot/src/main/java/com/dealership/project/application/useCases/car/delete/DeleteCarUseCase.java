package com.dealership.project.application.useCases.car.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.car.AbstractCarUseCase;
import com.dealership.project.infrastructure.repositories.JpaOrderRepository;
import com.dealership.project.presentation.exceptions.AssociationInUseException;
import com.dealership.project.presentation.exceptions.DatabaseException;
import com.dealership.project.presentation.exceptions.ResourceNotFoundException;

@Service
public class DeleteCarUseCase extends AbstractCarUseCase {

	@Autowired
	private JpaOrderRepository jpaOrderRepository;

    public void execute(DeleteCarUseCaseRequest request) {
        Long id = request.id();
        try {
			boolean isCarInUse = jpaOrderRepository.existsByCarId(id);

			if (!isCarInUse) {
				carRepository.deleteById(id);
			} else {
				throw new AssociationInUseException(String.format("This model is already in use"));
			}
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); //Passando exception da própria camada de serviço
		}
    }
}
