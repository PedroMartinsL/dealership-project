package com.dealership.project.infrastructure.security.authentication;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.dealership.project.application.services.UserService;
import com.dealership.project.domain.entities.UserMain;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserService userService;
    private final PasswordEncoder encoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String senhaDigitada = authentication.getCredentials().toString(); //pode ser credencial facial, digital, escrita -> to String

        //Switching the Name for Email requests
        UserMain userFound = userService.getUserByEmail(login);

        if (userFound == null) {
            throw getErrorUserNotFound();
        }

        String passwordCrypt = userFound.getPassword();

        boolean passwordMatches = getPasswordMatches(senhaDigitada, passwordCrypt);

        if (passwordMatches) {
            return new CustomAuthentication(userFound);
        }

        throw getErrorUserNotFound();
    }

    private boolean getPasswordMatches(String senhaDigitada, String senhaCriptografada) {
        return encoder.matches(senhaDigitada, senhaCriptografada);
    }

    private UsernameNotFoundException getErrorUserNotFound() {
        return new UsernameNotFoundException("Email or password are wrong!");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }

}
