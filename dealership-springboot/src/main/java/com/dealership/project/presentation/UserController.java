package com.dealership.project.presentation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dealership.project.api.dto.UserDTO;
import com.dealership.project.application.services.UserService;
import com.dealership.project.domain.entities.UserMain;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    // private final UserMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody UserDTO dto) {
        UserMain user = new UserMain(dto);
        userService.save(user);
    }

    @GetMapping
    public ResponseEntity<List<UserMain>> findAll() {
        List<UserMain> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/search")
    public ResponseEntity<UserMain> getUserByName(@RequestParam String name) {
        return ResponseEntity.ok(userService.getUserByName(name));
    }
}

