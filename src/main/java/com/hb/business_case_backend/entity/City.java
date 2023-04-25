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
@Table(name = "CTY_City")
public class City {

    // On ne génère pas d'id automatiquement, puisque l'on va manuellement utiliser
    // un code pour réprésenter le pays
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "CTY_city_id", nullable = false)
    private UUID cityId;

    // Libellé du nom du pays
    @Column(name = "CTY_postal_code", nullable = false, length = 8)
    private String postalCode;

    // Libellé du nom du pays
    @Column(name = "CTY_city_name", nullable = false, length = 255)
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "CNT_country_code")
    private Country country;

    public City(
            String postalCode,
            String cityName,
            Country country) {
        this.postalCode = postalCode;
        this.cityName = cityName;
        this.country = country;
    }
}
