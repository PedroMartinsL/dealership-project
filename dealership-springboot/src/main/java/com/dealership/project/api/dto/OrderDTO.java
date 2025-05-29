package com.dealership.project.api.dto;

import com.dealership.project.domain.entities.Car;
import com.dealership.project.domain.entities.Customization;
import com.dealership.project.domain.entities.Store;
import com.dealership.project.domain.entities.User;

import lombok.Data;

@Data
public class OrderDTO {
    private Car car;
    private User user;
    private Customization customization;
    private Store store;
}
