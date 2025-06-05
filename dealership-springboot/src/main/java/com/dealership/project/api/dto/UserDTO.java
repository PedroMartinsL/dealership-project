package com.dealership.project.api.dto;

import java.util.List;


public record UserDTO (
    String email,
    String password,
    List<String> roles) {
}
