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
@Table(name = "ADD_Add")
public class Add {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ADD_id", nullable = false)
    private UUID addId;

    @Column(name = "ADD_title", nullable = false, length = 255)
    private String addTitle;

    @Column(name = "ADD_image", nullable = false, length = 255)
    private String addImage;

    @Column(name = "ADD_description", nullable = false)
    private String addDescription;

    @ManyToOne
    @JoinColumn(name = "ADD_author")
    private User author;

    public Add(String addTitle, String addImage, String addDescription, User author) {
        this.addTitle = addTitle;
        this.addImage = addImage;
        this.addDescription = addDescription;
        this.author = author;
    }

}
