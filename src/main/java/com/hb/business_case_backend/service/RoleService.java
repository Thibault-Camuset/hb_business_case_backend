package com.hb.business_case_backend.service;

import com.hb.business_case_backend.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface RoleService {

    List<Role> getRoles();

    Role getRole(UUID roleId);

    Role createRole(String roleName, String roleDescription);

    Role updateRole(UUID roleId, String roleName, String roleDescription);

    boolean deleteRole(UUID roleId);

}
