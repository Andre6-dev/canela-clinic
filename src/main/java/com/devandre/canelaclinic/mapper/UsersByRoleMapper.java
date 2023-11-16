package com.devandre.canelaclinic.mapper;

import com.devandre.canelaclinic.dto.UsersByRoleDto;
import com.devandre.canelaclinic.entity.Role;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsersByRoleMapper {
    Role toEntity(UsersByRoleDto usersByRoleDto);

    UsersByRoleDto toDto(Role role);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Role partialUpdate(UsersByRoleDto usersByRoleDto, @MappingTarget Role role);
}