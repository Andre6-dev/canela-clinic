package com.devandre.canelaclinic.repository;

import com.devandre.canelaclinic.entity.Role;
import com.devandre.canelaclinic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE r.name = ?1")
    Optional<Role> findByName(String name);

    boolean existsRoleByName(String name);

    boolean existsRoleByRoleId(Long id);

}