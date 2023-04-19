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
@Table(name = "AD_Ad")
public class Ad {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "AD_id", nullable = false)
    private UUID adId;

    @Column(name = "AD_title", nullable = false, length = 255)
    private String adTitle;

    @Column(name = "AD_image", nullable = false, length = 255)
    private String adImage;

    @Column(name = "AD_description", nullable = false)
    private String adDescription;

    @Column(name = "AD_status", nullable = false)
    private String adStatus;

    @Column(name = "AD_isDeleted", nullable = false)
    private boolean adIsDeleted;

    @ManyToOne
    @JoinColumn(name = "AD_author")
    private User author;

    public Ad(String adTitle, String adImage, String adDescription, User author) {
        this.adTitle = adTitle;
        this.adImage = adImage;
        this.adDescription = adDescription;
        this.author = author;
    }

}
