package com.devandre.canelaclinic.service;

import com.devandre.canelaclinic.dao.RoleDao;
import com.devandre.canelaclinic.dto.RoleDto;
import com.devandre.canelaclinic.entity.Role;
import com.devandre.canelaclinic.exception.common.RequestValidationException;
import com.devandre.canelaclinic.exception.common.ResourceNotFoundException;
import com.devandre.canelaclinic.mapper.RoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * andre on 13/11/2023
 */
@Slf4j(topic = "RoleService")
@Service
public class RoleService {

    private final RoleDao roleDao;

    private final RoleMapper roleMapper;

    public RoleService(@Qualifier("roleDao") RoleDao roleDao, RoleMapper roleMapper) {
        this.roleDao = roleDao;
        this.roleMapper = roleMapper;
    }

    public List<RoleDto> getAllRoles() {
        log.info("Getting all roles");
        return roleDao.selectAllRoles()
                .stream()
                .map(roleMapper::toDto)
                .toList();
    }

    public RoleDto getRoleByName(String name) {
        log.info("Getting role with name [{}]", name);
        return this.roleDao.selectRoleByName(name)
                .map(roleMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Role with name [%s] not found".formatted(name)));
    }

    public RoleDto createRole(RoleDto roleDto) {
        log.info("Creating role with name [{}]", roleDto.name());
        if (roleDao.existsRoleWithName(roleDto.name())) {
            throw new IllegalStateException("Role with name [%s] already exists".formatted(roleDto.name()));
        }
        Role role = roleMapper.toEntity(roleDto);
        return roleMapper.toDto(roleDao.insertRole(role));
    }

    public void deleteRole(Long roleId) {
        log.info("Deleting role with id [{}]", roleId);
        if (!roleDao.existsRoleWithId(roleId)) {
            throw new ResourceNotFoundException("Role with id [%s] does not exists".formatted(roleId));
        }
        roleDao.deleteRoleById(roleId);
    }

    public RoleDto updateRole(Long roleId, RoleDto roleDto) {
        log.info("Updating role with name [{}]", roleDto.name());
        Role role = roleDao.selectRoleById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role with id [%s] not found".formatted(roleId)));

        boolean changes = false;

        if (roleDto.name() != null && !roleDto.name().equals(role.getName())) {
            role.setName(roleDto.name());
            changes = true;
        }

        if (!changes) {
            throw new RequestValidationException("No changes were made");
        }

        return roleMapper.toDto(roleDao.updateRole(role));
    }
}
