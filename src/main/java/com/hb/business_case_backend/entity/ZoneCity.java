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
@Table(name = "ZNC_Zone_City")
public class ZoneCity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ZNC_zone_city_id", nullable = false)
    private UUID zoneCityId;

    @ManyToOne
    private Zone zone;

    @ManyToOne
    private City city;

    public ZoneCity(Zone zone, City city) {
        this.zone = zone;
        this.city = city;
    }

}
