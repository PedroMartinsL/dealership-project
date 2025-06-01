package com.dealership.project.application.useCases.store.update;

import com.dealership.project.api.dto.StoreDTO;

public record UpdateStoreUseCaseRequest(Long id, StoreDTO storeDTO) {
}
