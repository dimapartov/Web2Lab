package com.example.websecondlab.models.base;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class CreatedModifiedBaseEntity extends IdBaseEntity {

    protected LocalDateTime created;
    protected LocalDateTime modified;


    @CreationTimestamp
    @Column(name = "created", nullable = false)
    public LocalDateTime getCreated() {
        return created;
    }

    @UpdateTimestamp
    @Column(name="modified", nullable = false)
    public LocalDateTime getModified() {
        return modified;
    }


    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}