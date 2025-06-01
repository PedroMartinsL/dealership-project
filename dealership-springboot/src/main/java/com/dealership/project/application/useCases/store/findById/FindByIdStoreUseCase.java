package com.dealership.project.application.useCases.store.findById;

import org.springframework.stereotype.Service;

import com.dealership.project.application.useCases.store.AbstractStoreUseCase;
import com.dealership.project.domain.entities.Store;
import com.dealership.project.presentation.exceptions.ResourceNotFoundException;

@Service
public class FindByIdStoreUseCase extends AbstractStoreUseCase {

  public FindByIdStoreUseCaseResponse execute(FindByIdStoreUseCaseRequest request) {
    Long id = request.StoreId();
    Store store = storeRepository.findById(id)
                                 .orElseThrow(() -> new ResourceNotFoundException(id));
    return new FindByIdStoreUseCaseResponse(store);
  }
}