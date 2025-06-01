package com.dealership.project.domain.entities;

import java.io.Serializable;
import java.time.Instant;

import com.dealership.project.api.dto.OrderDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @OneToOne(mappedBy = "order", cascade = CascadeType.REMOVE)
    private Customization customization;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant orderInstant;

    public Order() {

    }

    public Order(OrderDTO orderDTO) {
        this.car = orderDTO.getCar();
        this.customization = orderDTO.getCustomization();
        this.user = orderDTO.getUser();
        this.store = orderDTO.getStore();
        this.orderInstant = orderDTO.getOrderInstant();
    }

    public Order(Long id, Car car, Customization customization, User user, Store store, Instant orderInstant) {
        this.id = id;
        this.car = car;
        this.customization = customization;
        this.user = user;
        this.store = store;
        this.orderInstant = orderInstant;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public Customization getCustomization() {
        return customization;
    }

    public User getUser() {
        return user;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Instant getOrderInstant() {
        return orderInstant;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}