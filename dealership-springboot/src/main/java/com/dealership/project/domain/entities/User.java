package com.dealership.project.domain.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_data")
public class User extends EntityReference<UserProps> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders; 

    public User() {
        // Chama o construtor da superclasse (EntityReference) com parâmetros padrão
        super(null, null, null, null);
    }

    public User(UserProps props, String password) {
        super(props, null, null, null);
        this.password = password;
    }

    public User(UserProps props, String password, String id, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(props, id, createdAt, updatedAt);
        this.password = password;
    }

    public String getName() {
        return props.name();
    }

    public String getEmail() {
        return props.email();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
        touch(); // atualiza o updatedAt
    }

    public List<Order> getOrders() {
        return orders;
    }

    
}
