package com.hb.business_case_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "CNT_Country")
public class Country {

    // On ne génère pas d'id automatiquement, puisque l'on va manuellement utiliser un code pour réprésenter le pays
    @Id
    @Column(name = "CNT_country_code", nullable = false, length = 8)
    private String id;

    // Libellé du nom du pays
    @Column(name = "CNT_country_name", nullable = false)
    private String countryName;

}
