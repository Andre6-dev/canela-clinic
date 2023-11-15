package com.devandre.canelaclinic.service;

import com.devandre.canelaclinic.dao.RoleDao;
import com.devandre.canelaclinic.dao.UserDao;
import com.devandre.canelaclinic.entity.User;
import com.devandre.canelaclinic.dto.UserDto;
import com.devandre.canelaclinic.exception.common.ResourceNotFoundException;
import com.devandre.canelaclinic.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * andre on 14/11/2023
 */
@Slf4j(topic = "UserService")
@Service
public class UserService {

    private final UserDao userDao;
    private final RoleDao roleDao;

    private final UserMapper userMapper;

    public UserService(@Qualifier("userDao") UserDao userDao,
                       @Qualifier("roleDao") RoleDao roleDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.userMapper = userMapper;
    }

    public List<UserDto> getAllUsers() {
        log.info("Getting all users");
        return userDao.selectAllUsers()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    public UserDto getUserById(Long userId) {
        log.info("Getting user with id [{}]", userId);
        return this.userDao.selectUserById(userId)
                .map(userMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("User with id [%s] not found".formatted(userId)));
    }

    public UserDto createUser(Long roleId, UserDto userDto) {
        log.info("Creating user with username [{}]", userDto.username());
        if (userDao.existsUserWithUsername(userDto.username())) {
            throw new IllegalStateException("User with username [%s] already exists".formatted(userDto.username()));
        }

        User newUser = userDao.insertUser(userMapper.toEntity(userDto));

        // Assign role to user

        // newUser.assignRoleToUser(role);
        userDao.assignRoleToUser(userDto.username(), roleId);

        return userMapper.toDto(newUser);
    }

    public void deleteUser(Long userId) {
        log.info("Deleting user with id [{}]", userId);

        if (!userDao.existsUserWithId(userId)) {
            throw new ResourceNotFoundException("User with id [%s] does not exists".formatted(userId));
        }

        // Remove role from user
        userDao.selectUserById(userId).ifPresent(user -> {
            user.getRoles().forEach(role -> userDao.removeRoleFromUser(user.getUsername(), role.getRoleId()));
        });

        userDao.deleteUserById(userId);
    }

    public UserDto updateUser(Long userId, UserDto userDto) {
        log.info("Updating user with username [{}]", userDto.username());
        User user = userDao.selectUserById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id [%s] not found".formatted(userId)));

        boolean changes = false;

        if (userDto.username() != null && !userDto.username().equals(user.getUsername())) {
            user.setUsername(userDto.username());
            changes = true;
        }

        if (userDto.password() != null && !userDto.password().equals(user.getPassword())) {
            user.setPassword(userDto.password());
            changes = true;
        }

        if (!changes) {
            throw new RuntimeException("No changes were made");
        }

        return userMapper.toDto(userDao.updateUser(user));
    }

}
