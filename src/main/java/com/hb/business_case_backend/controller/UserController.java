package com.hb.business_case_backend.controller;

import com.hb.business_case_backend.entity.City;
import com.hb.business_case_backend.entity.User;
import com.hb.business_case_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @GetMapping("/{userId}")
    public User userGet(@PathVariable UUID userId) {
        return userService.getUser(userId);
    }

    @PostMapping("/{userEmail}/{userPassword}/{userFirstName}/{userLastName}/{userPhone}/{userAddress}/{city}")
    @ResponseStatus(code= HttpStatus.CREATED)
    public User userPost(@PathVariable String userEmail, @PathVariable String userPassword, @PathVariable String userFirstName, @PathVariable String userLastName, @PathVariable String userPhone, @PathVariable String userAddress, @PathVariable City city) {
        return userService.createUser(userEmail, userPassword, userFirstName, userLastName, userPhone, userAddress, city);
    }

    @PatchMapping("/{userId}/{userEmail}/{userPassword}/{userFirstName}/{userLastName}/{userPhone}/{userAddress}/{city}")
    public User userPatch(@PathVariable UUID userId, @PathVariable String userEmail, @PathVariable String userPassword, @PathVariable String userFirstName, @PathVariable String userLastName, @PathVariable String userPhone, @PathVariable String userAddress, @PathVariable City city) {
        return userService.updateUser(userId, userEmail, userPassword, userFirstName, userLastName, userPhone, userAddress, city);
    }

    @DeleteMapping("/{userId}")
    public boolean userDelete(@PathVariable UUID userId) {
        return userService.deleteUser(userId);
    }

    @GetMapping("")
    public List<User> usersGet() {
        return userService.getUsers();
    }

}
