package com.hb.business_case_backend.fixture;

import com.hb.business_case_backend.entity.Role;
import com.hb.business_case_backend.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class RoleFixture {

    private RoleService roleService;

    public void addRoles() {

        List<Role> roles = roleService.getRoles();

        if(roles.isEmpty()) {

            roleService.createRole("USER","Role de base pour les utilisateurs");
            roleService.createRole("ADMIN","Role pour l'administration de l'api");

        }

    }

}
