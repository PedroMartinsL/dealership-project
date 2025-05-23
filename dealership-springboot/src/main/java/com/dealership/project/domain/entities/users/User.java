package com.dealership.project.domain.entities.users;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;

@Entity
public class User extends EntityReference<UserProps> implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String password;

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
}
