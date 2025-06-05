package com.dealership.project.domain.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class UserProps {

    private String email;
    private String name;

    public UserProps(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public UserProps() {}
}
