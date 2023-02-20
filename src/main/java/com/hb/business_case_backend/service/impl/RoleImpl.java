package com.hb.business_case_backend.service.impl;

import com.hb.business_case_backend.entity.Role;
import com.hb.business_case_backend.repository.RoleRepository;
import com.hb.business_case_backend.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RoleImpl implements RoleService {


    private final RoleRepository roleRepository;

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRole(UUID roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }

    @Override
    public Role createRole(String roleName, String roleDescription) {
        Role role = new Role(roleName, roleDescription);
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(UUID roleId, String roleName, String roleDescription) {
        Role role = roleRepository.findById(roleId).orElse(null);
        if(role != null) {
            role.setRoleDescription(roleDescription);
            role.setRoleName(roleName);
        }
        return roleRepository.save(role);
    }

    @Override
    public boolean deleteRole(UUID roleId) {
        Role role = roleRepository.findById(roleId).orElse(null);
        if(role == null) {
            return false;
        } else {
            roleRepository.deleteById(roleId);
            return true;
        }
    }
}
