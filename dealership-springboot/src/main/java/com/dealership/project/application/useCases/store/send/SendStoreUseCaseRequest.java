package com.dealership.project.application.useCases.store.send;

import com.dealership.project.api.dto.StoreDTO;

public record SendStoreUseCaseRequest(
  StoreDTO storeDTO
) {
}