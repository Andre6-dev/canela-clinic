package com.devandre.canelaclinic.mapper;

import com.devandre.canelaclinic.dto.UsersByRoleDto;
import com.devandre.canelaclinic.entity.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsersMapper {
    User toEntity(UsersByRoleDto.UsersDto usersDto);

    UsersByRoleDto.UsersDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UsersByRoleDto.UsersDto usersDto, @MappingTarget User user);
}