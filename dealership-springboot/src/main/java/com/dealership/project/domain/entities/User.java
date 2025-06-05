package com.dealership.project.domain.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.Type;

import com.dealership.project.api.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "user_data")
@EqualsAndHashCode(callSuper = false)
public class User extends EntityReference<UserProps> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Embedded
    private UserProps props;

    @Type(ListArrayType.class)
    @Column(name = "roles", columnDefinition = "varchar[]")
    private List<String> roles;

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

    public User(UserDTO dto) {
        super(null, null, null, null); // ou chame como precisar
        this.props = new UserProps(dto.email(), dto.name()); // atribuição correta
        this.password = dto.password();
        this.roles = dto.roles();
    }

    public String getName() {
        return props.getEmail();
    }

    public void setName(String name) {
        props.setName(name);
        touch();
    }

    public String getEmail() {
        return props.getEmail();
    }

    public void setEmail(String email) {
        props.setEmail(email);
        touch();
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public UserProps getProps() {
        return props;
    }

    public List<String> getRoles() {
        return roles;
    }
}
