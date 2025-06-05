package com.dealership.project.application.services;

import com.dealership.project.domain.entities.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dealership.project.infrastructure.repositories.JpaUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final JpaUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void save(User user) {
        var password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    public User GetUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
