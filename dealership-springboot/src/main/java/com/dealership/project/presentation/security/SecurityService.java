package com.dealership.project.presentation.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.dealership.project.application.services.UserService;
import com.dealership.project.domain.entities.UserMain;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SecurityService {

    private UserService userService;

    public UserMain getUserLogged() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userdetails = (UserDetails) authentication.getPrincipal();
        String name = userdetails.getUsername();
        return userService.getUserByName(name);
    }
}
