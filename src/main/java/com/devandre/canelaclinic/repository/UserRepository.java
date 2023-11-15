package com.devandre.canelaclinic.repository;

import com.devandre.canelaclinic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u inner join u.roles roles where roles.roleId = ?1")
    List<User> findByRoles_RoleId(@Param("roleId") Long roleId);

    boolean existsUserByUsername(String username);

    boolean existsUserByUserId(Long id);

    @Query("select u from User u where u.username = ?1")
    Optional<User> findByUsername(String username);

}