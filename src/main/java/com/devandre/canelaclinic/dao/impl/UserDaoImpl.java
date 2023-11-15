package com.devandre.canelaclinic.dao.impl;

import com.devandre.canelaclinic.dao.UserDao;
import com.devandre.canelaclinic.entity.Role;
import com.devandre.canelaclinic.entity.User;
import com.devandre.canelaclinic.repository.RoleRepository;
import com.devandre.canelaclinic.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * andre on 14/11/2023
 */
@Repository("userDao")
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public List<User> selectAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> selectUserById(Long roleId) {
        return userRepository.findById(roleId);
    }


    @Override
    public List<User> selectUsersByRoleId(Long roleId) {
        return null;
    }

    @Override
    public User insertUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean existsUserWithUsername(String username) {
        return userRepository.existsUserByUsername(username);
    }

    @Override
    public boolean existsUserWithId(Long id) {
        return userRepository.existsUserByUserId(id);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void assignRoleToUser(String username, Long roleId) {
        Optional<Role> role = roleRepository.findById(roleId);
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && role.isPresent()) {
            user.get().getRoles().add(role.get());
            userRepository.save(user.get());
        } else {
            throw new RuntimeException("User or Role not found");
        }
    }

    @Override
    public void removeRoleFromUser(String username, Long roleId) {
        Optional<Role> role = roleRepository.findById(roleId);
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && role.isPresent()) {
            user.get().getRoles().remove(role.get());
            userRepository.save(user.get());
        } else {
            throw new RuntimeException("User or Role not found");
        }
    }


}
