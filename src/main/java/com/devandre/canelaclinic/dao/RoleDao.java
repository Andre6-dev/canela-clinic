package com.devandre.canelaclinic.dao;

import com.devandre.canelaclinic.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleDao {

    List<Role> selectAllRoles();

    Optional<Role> selectRoleByName(String name);

    Optional<Role> selectRoleById(Long id);

    Role insertRole(Role role);

    boolean existsRoleWithName(String name);

    boolean existsRoleWithId(Long id);

    void deleteRoleById(Long id);

    Role updateRole(Role role);
}
