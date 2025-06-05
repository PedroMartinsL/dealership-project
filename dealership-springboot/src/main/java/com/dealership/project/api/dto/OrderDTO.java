package com.dealership.project.api.dto;

import java.time.Instant;

import com.dealership.project.domain.entities.Car;
import com.dealership.project.domain.entities.Customization;
import com.dealership.project.domain.entities.Store;
import com.dealership.project.domain.entities.UserMain;

import lombok.Data;

@Data
public class OrderDTO {
    private Car car;
    private UserMain user;
    private Customization customization;
    private Store store;
    private Instant orderInstant;
}
