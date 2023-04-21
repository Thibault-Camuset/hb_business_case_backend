package com.hb.business_case_backend.dto;

import java.util.UUID;

import com.hb.business_case_backend.entity.City;
import com.hb.business_case_backend.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private UUID userId;

    private String userEmail;

    private String userFirstName;

    private String userLastName;

    private String userPhone;

    private String userAddress;

    private City userCity;

    private Role userRole;

}