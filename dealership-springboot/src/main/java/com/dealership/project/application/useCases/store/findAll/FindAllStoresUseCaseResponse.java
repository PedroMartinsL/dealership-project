package com.dealership.project.application.useCases.store.findAll;

import java.util.List;

import com.dealership.project.domain.entities.Store;

public record FindAllStoresUseCaseResponse (
  List<Store> stores
) {
}