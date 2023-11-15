package com.devandre.canelaclinic.dto;

import com.devandre.canelaclinic.dto.RoleDto;
import com.devandre.canelaclinic.entity.User;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link User}
 */
public record UserDto(Long userId, String username, String password, boolean enabled,
                      Set<RoleDto> roles) implements Serializable {
}