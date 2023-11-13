package com.devandre.canelaclinic.dao.impl;

import com.devandre.canelaclinic.dao.RoleDao;
import com.devandre.canelaclinic.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * andre on 13/11/2023
 */
@Repository("roleDao")
@RequiredArgsConstructor
public class RoleDaoImpl implements RoleDao {

    private final RoleRepository roleRepository;
}
