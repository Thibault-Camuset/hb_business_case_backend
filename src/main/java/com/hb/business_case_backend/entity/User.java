package com.hb.business_case_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "USR_User")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "USR_id", nullable = false)
    private UUID userId;

    @Column(name = "USR_email", nullable = false)
    private String userEmail;

    @JsonIgnore
    @Column(name = "USR_password", nullable = false)
    private String userPassword;

    @Column(name = "USR_first_name", nullable = false)
    private String userFirstName;

    @Column(name = "USR_last_name", nullable = false)
    private String userLastName;

    @Column(name = "USR_phone", nullable = true)
    private String userPhone;

    @Column(name = "USR_address", nullable = true)
    private String userAddress;

    @ManyToOne
    @JoinColumn(name = "USR_city")
    private City userCity;

    @ManyToOne
    @JoinColumn(name = "USR_role")
    private Role userRole;

    public User(String userEmail, String userPassword, String userFirstName, String userLastName, String userPhone,
            String userAddress, City city, Role role) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.userCity = city;
        this.userRole = role;
    }

    // Méthodes nécessaires à l'implémentation de UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userRole.getRoleName()));
    }

    @Override
    public String getUsername() {
        return userEmail;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
