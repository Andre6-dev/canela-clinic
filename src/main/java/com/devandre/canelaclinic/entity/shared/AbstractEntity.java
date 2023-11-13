package com.devandre.canelaclinic.entity.shared;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

/**
 * andre on 10/11/2023
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity {

    @Column(name = "created_at", nullable = false)
    private Instant createdAt = Instant.now();

    @Column(name = "last_modified_at")
    private Instant lastModifiedAt;
}
