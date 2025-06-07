package com.dealership.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.dealership.project.application.services.UserService;
import com.dealership.project.presentation.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled= true, jsr250Enabled= true)
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(AbstractHttpConfigurer::disable)
            .httpBasic(Customizer.withDefaults())
            .formLogin(configurer -> configurer.loginPage("/login"))
            .authorizeHttpRequests(authorize -> 
            {
                authorize.requestMatchers("/login/**").permitAll();
                authorize.requestMatchers(HttpMethod.POST, "/users/**").permitAll();
                authorize.anyRequest().authenticated();
            })
        .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Times passed throught code entered
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public UserDetailsService userDetailsService(UserService userService) {
        // Who seeds the User
        return new CustomUserDetailsService(userService);
    }
}
