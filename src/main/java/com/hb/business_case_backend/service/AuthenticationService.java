package com.hb.business_case_backend.service;

import com.hb.business_case_backend.authentication.AuthenticationResponse;
import com.hb.business_case_backend.entity.Token;
import com.hb.business_case_backend.repository.RoleRepository;
import com.hb.business_case_backend.repository.TokenRepository;
import com.hb.business_case_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.hb.business_case_backend.entity.User;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse register(String userLastName, String userFirstName, String userEmail, String userPassword) {
        var user = User.builder()
                .userFirstName(userFirstName)
                .userLastName(userLastName)
                .userEmail(userEmail)
                .userPassword(passwordEncoder.encode(userPassword))
                .userRole(roleRepository.findOneByRoleName("USER"))
                .build();
        var savedUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(String userEmail, String userPassword) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userEmail,
                        userPassword
                )
        );
        var user = userRepository.findByUserEmail(userEmail)
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType("Bearer")
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getUserId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

}
