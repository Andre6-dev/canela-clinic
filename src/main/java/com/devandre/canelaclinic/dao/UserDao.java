package com.devandre.canelaclinic.dao;

import com.devandre.canelaclinic.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<User> selectAllUsers();

    Optional<User> selectUserById(Long roleId);

    List<User> selectUsersByRoleId(Long roleId);

    User insertUser(User user);

    boolean existsUserWithUsername(String username);

    boolean existsUserWithId(Long id);

    void deleteUserById(Long id);

    User updateUser(User user);

    void assignRoleToUser(String username, Long roleId);

    void removeRoleFromUser(String username, Long roleId);
}

