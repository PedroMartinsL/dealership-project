package com.dealership.project.presentation;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dealership.project.api.dto.StoreDTO;
import com.dealership.project.application.useCases.Store.findAll.FindAllStoresUseCase;
import com.dealership.project.application.useCases.Store.findAll.ListStoresUseCase;
import com.dealership.project.application.useCases.Store.findAll.ListStoresUseCaseResponse;
import com.dealership.project.application.useCases.Store.findById.FindByIdStoreUseCase;
import com.dealership.project.application.useCases.Store.findById.GetStoreUseCase;
import com.dealership.project.application.useCases.Store.findById.GetStoreUseCaseRequest;
import com.dealership.project.application.useCases.Store.findById.GetStoreUseCaseResponse;
import com.dealership.project.application.useCases.Store.delete.DeleteStoreUseCaseRequest;
import com.dealership.project.application.useCases.Store.send.SendStoreUseCaseRequest;
import com.dealership.project.application.useCases.Store.send.SendStoreUseCaseResponse;
import com.dealership.project.application.useCases.Store.update.UpdateStoreUseCaseRequest;
import com.dealership.project.application.useCases.Store.update.UpdateStoreUseCaseResponse;
import com.dealership.project.domain.entities.Store;

@Controller
@RequestMapping(value = "/stores")
public class StoreController {

    @Autowired
    private SendStoreUseCase sendStoreUseCase;

    @Autowired
    private FindByIdStoreUseCase findByIdStoreUseCase;

    @Autowired
    private FindAllStoresUseCase findAllStoresUseCase;

    @Autowired
    private UpdateStoreUseCase updateStoreUseCase;
    
    @GetMapping
	public ResponseEntity<ListStoresUseCaseResponse> findAll() {
		ListStoresUseCaseResponse response = listStoresUseCase.execute();
		return ResponseEntity.ok().body(response);
	}

    @GetMapping(value = "/{id}")
	public ResponseEntity<GetStoreUseCaseResponse> findById(@PathVariable Long id) {
		GetStoreUseCaseRequest getStoreUseCaseRequest = new GetStoreUseCaseRequest(id);
		GetStoreUseCaseResponse response = getStoreUseCase.execute(getStoreUseCaseRequest);
		return ResponseEntity.ok().body(response);
	}

	@PostMapping
    public ResponseEntity<Store> insert(
        @RequestBody StoreDTO StoreDTO
    ) {
        SendStoreUseCaseRequest StoreRequest = new SendStoreUseCaseRequest(StoreDTO);
        SendStoreUseCaseResponse StoreResponse = sendStoreUseCase.execute(StoreRequest);
        Store Store = StoreResponse.Store();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Store.getId()).toUri();
		return ResponseEntity.created(uri).body(Store);
    }

    @DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
        DeleteStoreUseCaseRequest request = new DeleteStoreUseCaseRequest(id);
		deleteStoreUseCase.execute(request);
		return ResponseEntity.noContent().build();
	}

    @PutMapping("/{id}")
    public ResponseEntity<Store> update(@PathVariable Long id, @RequestBody StoreDTO StoreDTO) {
        UpdateStoreUseCaseRequest request = new UpdateStoreUseCaseRequest(id, StoreDTO);
		UpdateStoreUseCaseResponse response = updateStoreUseCase.execute(request);
        Store Store = response.Store();
		return ResponseEntity.ok().body(Store);
	}
}
