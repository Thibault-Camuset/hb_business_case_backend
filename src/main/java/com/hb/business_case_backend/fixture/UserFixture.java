package com.hb.business_case_backend.fixture;

import com.hb.business_case_backend.entity.Role;
import com.hb.business_case_backend.entity.User;
import com.hb.business_case_backend.service.AuthenticationService;
import com.hb.business_case_backend.service.RoleService;
import com.hb.business_case_backend.service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class UserFixture {

    private AuthenticationService authService;
    private UserService userService;
    private RoleService roleService;

    public void addUsers() {

        List<User> users = userService.getUsers();

        if (users.isEmpty()) {

            authService.register(
                    "Admin",
                    "Admin",
                    "admin@gmail.com",
                    "admin");

            Role role = roleService.getRoleByRoleName("ADMIN");

            User admin = userService.getUserByEmail("admin@gmail.com");
            admin.setUserRole(role);
            userService.updateUser(
                    admin.getUserId(),
                    admin.getUserEmail(),
                    admin.getPassword(),
                    admin.getUserFirstName(),
                    admin.getUserLastName(),
                    null,
                    null,
                    null,
                    admin.getUserRole());

        }

    }
}
