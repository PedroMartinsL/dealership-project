package com.dealership.project.domain.entities.offers;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car implements Serializable {
    
    private static final long serialVersionUID = 1L;
}
