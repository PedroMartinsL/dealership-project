package com.dealership.project.domain.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class UserProps {
    private String name;
    private String email;
}
