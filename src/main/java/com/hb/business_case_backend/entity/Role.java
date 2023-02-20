package com.hb.business_case_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ROL_Role")
public class Role {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ROL_role_id", nullable = false)
    private UUID roleId;

    @Column(name = "ROL_role_name", nullable = false, length = 255)
    private String roleName;

    @Column(name = "ROL_role_description", nullable = false, length = 255)
    private String roleDescription;

    public Role(String roleName, String roleDescription) {
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

}
