package com.dealership.project.application.useCases.store.update;

import org.springframework.stereotype.Service;

import com.dealership.project.api.dto.StoreDTO;
import com.dealership.project.application.useCases.store.AbstractStoreUseCase;
import com.dealership.project.domain.entities.Store;
import com.dealership.project.presentation.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UpdateStoreUseCase extends AbstractStoreUseCase {

    @Transactional
    public UpdateStoreUseCaseResponse execute(UpdateStoreUseCaseRequest request) {
        Long id = request.id();
        StoreDTO storeDTO = request.storeDTO();
        try {
            Store store = storeRepository.getReferenceById(id);
            updateData(store, storeDTO);
            store = storeRepository.save(store);
            UpdateStoreUseCaseResponse response = new UpdateStoreUseCaseResponse(store);
            return response;
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Store store, StoreDTO storeDTO) {
        store.setAddressNumber(storeDTO.getAddressNumber());
        store.setCity(storeDTO.getCity());
        store.setLogo(storeDTO.getLogo());
        store.setStreet(storeDTO.getCity());
        store.setState(storeDTO.getState());
    }
}
