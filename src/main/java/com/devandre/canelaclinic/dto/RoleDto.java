package com.devandre.canelaclinic.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link com.devandre.canelaclinic.entity.Role}
 */
public record RoleDto(Long roleId, @NotNull String name) implements Serializable {
}