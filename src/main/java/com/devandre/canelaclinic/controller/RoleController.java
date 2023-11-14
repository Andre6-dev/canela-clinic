package com.devandre.canelaclinic.controller;

import com.devandre.canelaclinic.dto.RoleDto;
import com.devandre.canelaclinic.entity.Role;
import com.devandre.canelaclinic.entity.common.ResponseHandler;
import com.devandre.canelaclinic.repository.RoleRepository;
import com.devandre.canelaclinic.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.devandre.canelaclinic.utiils.Constants.API_BASE_PATH;

/**
 * andre on 13/11/2023
 */
@RestController
@RequestMapping(API_BASE_PATH + "roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @GetMapping
    public ResponseEntity<Object> getAllRoles() {
        return ResponseHandler.response(HttpStatus.OK, roleService.getAllRoles(), true);
    }

    @GetMapping("/{roleName}")
    public ResponseEntity<Object> getRoleByName(@PathVariable("roleName") String roleName) {
        return ResponseHandler.response(HttpStatus.OK, roleService.getRoleByName(roleName), true);
    }

    @PostMapping
    public ResponseEntity<Object> createRole(@Valid @RequestBody RoleDto roleDto) {
        return ResponseHandler.response(HttpStatus.OK, roleService.createRole(roleDto), true);
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<Object> deleteRole(@PathVariable("roleId") Long roleId) {
        roleService.deleteRole(roleId);
        return ResponseHandler.response(HttpStatus.OK, "Role deleted successfully", true);
    }

    @PutMapping("/{roleId}")
    public ResponseEntity<Object> updateRole(@PathVariable("roleId") Long roleId, @Valid @RequestBody RoleDto roleDto) {
        return ResponseHandler.response(HttpStatus.OK, roleService.updateRole(roleId, roleDto), true);
    }
}
