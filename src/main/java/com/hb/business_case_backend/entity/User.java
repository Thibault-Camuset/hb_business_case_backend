package com.hb.business_case_backend.entity;

import jakarta.persistence.*;
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
@Table(name = "USR_User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "USR_user_id", nullable = false)
    private UUID userId;

    @Column(name = "USR_user_email", nullable = false)
    private String userEmail;

    @Column(name = "USR_user_password", nullable = false)
    private String userPassword;

    @Column(name = "USR_user_first_name", nullable = false)
    private String userFirstName;

    @Column(name = "USR_user_last_name", nullable = false)
    private String userLastName;

    @Column(name = "USR_user_phone", nullable = false)
    private String userPhone;

    @Column(name = "USR_user_address", nullable = false)
    private String userAddress;

    @ManyToOne
    @JoinColumn(name = "USR_user_city")
    private City userCity;

    public User(String userEmail, String userPassword, String userFirstName, String userLastName, String userPhone, String userAddress, City city) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.userCity = city;
    }
}
