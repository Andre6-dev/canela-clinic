package com.devandre.canelaclinic.controller;

import com.devandre.canelaclinic.dto.UserDto;
import com.devandre.canelaclinic.entity.common.ResponseHandler;
import com.devandre.canelaclinic.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.devandre.canelaclinic.utiils.Constants.API_BASE_PATH;

/**
 * andre on 14/11/2023
 */
@RestController
@RequestMapping(API_BASE_PATH + "users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        return ResponseHandler.response(HttpStatus.OK, userService.getAllUsers(), true);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUserById(@PathVariable("userId") Long userId) {
        return ResponseHandler.response(HttpStatus.OK, userService.getUserById(userId), true);
    }

    @PostMapping("/role/{roleId}")
    public ResponseEntity<Object> createUser(@PathVariable("roleId") Long roleId, @RequestBody UserDto user) {
        return ResponseHandler.response(HttpStatus.OK, userService.createUser(roleId, user), true);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return ResponseHandler.response(HttpStatus.OK, "User deleted successfully", true);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Object> updateUser(@PathVariable("userId") Long userId, @RequestBody UserDto user) {
        return ResponseHandler.response(HttpStatus.OK, userService.updateUser(userId, user), true);
    }

}
