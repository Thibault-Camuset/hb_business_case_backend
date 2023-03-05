package com.hb.business_case_backend.service;

import com.hb.business_case_backend.entity.City;
import com.hb.business_case_backend.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {

    List<User> getUsers();

    User getUser(UUID userId);

    User createUser(String userEmail, String userPassword, String userFirstName, String userLastName, String userPhone, String userAddress, City city);

    User updateUser(UUID userId, String userEmail, String userPassword, String userFirstName, String userLastName, String userPhone, String userAddress, City city);

    boolean deleteUser(UUID userId);
}
