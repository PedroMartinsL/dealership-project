package com.dealership.project.infrastructure.security;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
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
        String email = userdetails.getUsername();
        return userService.getUserByEmail(email);
    }

    public boolean isAdmin() {
        return getRoles().contains("ROLE_ADMIN");
    }

    public String getUserEmail() {
        return getAuthentication().getName(); // email
    }

    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    private List<String> getRoles() {
        return getAuthentication().getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .toList();
    }
}
