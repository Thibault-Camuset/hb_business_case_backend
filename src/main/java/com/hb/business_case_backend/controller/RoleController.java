package com.hb.business_case_backend.controller;

import com.hb.business_case_backend.entity.Role;
import com.hb.business_case_backend.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/roles")
public class RoleController {

    private RoleService roleService;

    @GetMapping("/{roleId}")
    public Role roleGet(@PathVariable UUID roleId) {
        return roleService.getRole(roleId);
    }

    @PostMapping("/{roleName}/{roleDescription}")
    @ResponseStatus(code= HttpStatus.CREATED)
    public Role rolePost(@PathVariable String roleName, @PathVariable String roleDescription) {
        return roleService.createRole(roleName, roleDescription);
    }

    @PatchMapping("/{roleId}/{roleName}/{roleDescription}")
    public Role rolePatch(@PathVariable UUID roleId, @PathVariable String roleName, @PathVariable String roleDescription) {
        return roleService.updateRole(roleId, roleName, roleDescription);
    }

    @DeleteMapping("/{roleId}")
    public boolean roleDelete(@PathVariable UUID roleId) {
        return roleService.deleteRole(roleId);
    }

    @GetMapping("")
    public List<Role> rolesGet() {
        return roleService.getRoles();
    }

}
