package com.hb.business_case_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "TKN_Token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "TKN_id", nullable = false)
    private UUID tokenId;

    @Column(name = "TKN_token", unique = true)
    public String token;

    @Column(name = "TKN_token_type")
    public String tokenType = "Bearer";

    @Column(name = "TKN_revoked")
    public boolean revoked;

    @Column(name = "TKN_expired")
    public boolean expired;

    @ManyToOne
    @JoinColumn(name = "TKN_user_id")
    public User user;

}
