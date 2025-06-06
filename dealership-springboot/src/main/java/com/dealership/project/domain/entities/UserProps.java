package com.dealership.project.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class UserProps {

    @Column(name = "email", unique = true, nullable = false)
    private String email;
    
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    public UserProps(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public UserProps() {}
}
