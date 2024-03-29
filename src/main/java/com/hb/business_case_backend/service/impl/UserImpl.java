package com.hb.business_case_backend.service.impl;

import com.hb.business_case_backend.entity.City;
import com.hb.business_case_backend.entity.Role;
import com.hb.business_case_backend.entity.User;
import com.hb.business_case_backend.repository.UserRepository;
import com.hb.business_case_backend.service.RoleService;
import com.hb.business_case_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(UUID userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User getUserByEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail).orElse(null);
    }

    @Override
    public User createUser(String userEmail, String userPassword, String userFirstName, String userLastName,
            String userPhone, String userAddress, City city, Role role) {
        Role roleUser = roleService.getRoleByRoleName("USER");
        User user = new User(userEmail, userPassword, userFirstName, userLastName, userPhone, userAddress, city,
                roleUser);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(UUID userId, String userEmail, String userPassword, String userFirstName,
            String userLastName, String userPhone, String userAddress, City city, Role role) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setUserEmail(userEmail);
            user.setUserPassword(userPassword);
            user.setUserFirstName(userFirstName);
            user.setUserLastName(userLastName);
            user.setUserPhone(userPhone);
            user.setUserAddress(userAddress);
            user.setUserCity(city);
            user.setUserRole(role);
        }
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(UUID userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return false;

        } else {
            userRepository.deleteById(userId);
            return true;
        }
    }

}
