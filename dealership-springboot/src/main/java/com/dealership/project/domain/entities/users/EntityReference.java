package com.dealership.project.domain.entities.users;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public abstract class EntityReference<T> {
    private final String id;
    protected UserProps props;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public EntityReference(UserProps props, String id, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = (id != null) ? id : UUID.randomUUID().toString();
        this.props = props;
        this.createdAt = (createdAt != null) ? createdAt : LocalDateTime.now();
        this.updatedAt = (updatedAt != null) ? updatedAt : LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    protected void touch() {
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EntityReference<?> entity = (EntityReference<?>) obj;
        return Objects.equals(id, entity.id);
    }
}