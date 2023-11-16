package com.devandre.canelaclinic.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.devandre.canelaclinic.entity.Role}
 */
public record UsersByRoleDto(String name, Set<UsersDto> users) implements Serializable {
    /**
     * DTO for {@link com.devandre.canelaclinic.entity.User}
     */
    public record UsersDto(Long userId, String username, boolean enabled) implements Serializable {
    }
}