package com.dealership.project.presentation;

import java.net.URI;
import java.util.List;

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

import com.dealership.project.api.dto.EngineDTO;
import com.dealership.project.application.useCases.Engine.delete.DeleteEngineUseCase;
import com.dealership.project.application.useCases.Engine.delete.DeleteEngineUseCaseRequest;
import com.dealership.project.application.useCases.Engine.findAll.FindAllEnginesUseCase;
import com.dealership.project.application.useCases.Engine.findAll.FindAllEnginesUseCaseResponse;
import com.dealership.project.application.useCases.Engine.findById.FindByIdEngineUseCase;
import com.dealership.project.application.useCases.Engine.findById.FindByIdEngineUseCaseRequest;
import com.dealership.project.application.useCases.Engine.findById.FindByIdEngineUseCaseResponse;
import com.dealership.project.application.useCases.Engine.findByStore.FindByStoreEngineUseCase;
import com.dealership.project.application.useCases.Engine.findByStore.FindByStoreEngineUseCaseRequest;
import com.dealership.project.application.useCases.Engine.findByStore.FindByStoreEngineUseCaseResponse;
import com.dealership.project.application.useCases.Engine.findByUser.FindByUserEngineUseCase;
import com.dealership.project.application.useCases.Engine.findByUser.FindByUserEngineUseCaseRequest;
import com.dealership.project.application.useCases.Engine.findByUser.FindByUserEngineUseCaseResponse;
import com.dealership.project.application.useCases.Engine.send.SendEngineUseCase;
import com.dealership.project.application.useCases.Engine.send.SendEngineUseCaseRequest;
import com.dealership.project.application.useCases.Engine.send.SendEngineUseCaseResponse;
import com.dealership.project.application.useCases.Engine.update.UpdateEngineUseCase;
import com.dealership.project.application.useCases.Engine.update.UpdateEngineUseCaseRequest;
import com.dealership.project.application.useCases.Engine.update.UpdateEngineUseCaseResponse;
import com.dealership.project.domain.entities.Engine;

@Controller
@RequestMapping(value = "/engines")
public class EngineController {

    @Autowired
    private SendEngineUseCase sendEngineUseCase;

    @Autowired
    private FindByIdEngineUseCase findByIdEngineUseCase;

    @Autowired
    private FindAllEnginesUseCase findAllEnginesUseCase;

    @Autowired
    private UpdateEngineUseCase updateEngineUseCase;

    @GetMapping
    public ResponseEntity<List<Engine>> findAll() {
		FindAllEnginesUseCaseResponse response = findAllEnginesUseCase.execute();
        List<Engine> EnginesList = response.Engines();
		return ResponseEntity.ok().body(EnginesList);
	}

    @GetMapping("/{id}")
    public ResponseEntity<Engine> findById(@PathVariable Long id) {
		FindByIdEngineUseCaseRequest EngineRequest = new FindByIdEngineUseCaseRequest(id);
        FindByIdEngineUseCaseResponse EngineReponse = findByIdEngineUseCase.execute(EngineRequest);
        Engine Engine = EngineReponse.Engine();
		return ResponseEntity.ok().body(Engine);
	}

    @PostMapping
    public ResponseEntity<Engine> insert(
        @RequestBody EngineDTO EngineDTO
    ) {
        SendEngineUseCaseRequest EngineRequest = new SendEngineUseCaseRequest(EngineDTO);
        SendEngineUseCaseResponse EngineResponse = sendEngineUseCase.execute(EngineRequest);
        Engine Engine = EngineResponse.Engine();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Engine.getId()).toUri();
		return ResponseEntity.created(uri).body(Engine);
    }

    // Deactive
    @PutMapping("/{id}")
    public ResponseEntity<Engine> update(@PathVariable Long id, @RequestBody EngineDTO EngineDTO) {
        UpdateEngineUseCaseRequest request = new UpdateEngineUseCaseRequest(id, EngineDTO);
		UpdateEngineUseCaseResponse response = updateEngineUseCase.execute(request);
        Engine Engine = response.Engine();
		return ResponseEntity.ok().body(Engine);
	}
}
