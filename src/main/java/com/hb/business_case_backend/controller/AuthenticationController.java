package com.hb.business_case_backend.controller;

import com.hb.business_case_backend.authentication.AuthenticationRequest;
import com.hb.business_case_backend.authentication.AuthenticationResponse;
import com.hb.business_case_backend.authentication.RegisterRequest;
import com.hb.business_case_backend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestParam String userLastName,
            @RequestParam String userFirstName,
            @RequestParam String userEmail,
            @RequestParam String userPassword
    ) {
        return ResponseEntity.ok(service.register(userLastName, userFirstName, userEmail, userPassword));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestParam String userEmail,
            @RequestParam String userPassword
    ) {
        return ResponseEntity.ok(service.authenticate(userEmail, userPassword));
    }

}
