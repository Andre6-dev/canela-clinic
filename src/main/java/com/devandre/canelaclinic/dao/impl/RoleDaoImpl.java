package com.devandre.canelaclinic.dao.impl;

import com.devandre.canelaclinic.dao.RoleDao;
import com.devandre.canelaclinic.entity.Role;
import com.devandre.canelaclinic.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * andre on 13/11/2023
 */
@Repository("roleDao")
@RequiredArgsConstructor
public class RoleDaoImpl implements RoleDao {

    private final RoleRepository roleRepository;

    @Override
    public List<Role> selectAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> selectRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Optional<Role> selectRoleById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role insertRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public boolean existsRoleWithName(String name) {
        return roleRepository.existsRoleByName(name);
    }

    @Override
    public boolean existsRoleWithId(Long id) {
        return roleRepository.existsRoleByRoleId(id);
    }

    @Override
    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }
}
