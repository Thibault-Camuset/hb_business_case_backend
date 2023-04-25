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
@Table(name = "ZNE_Zone")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ZNE_zone_id", nullable = false)
    private UUID zoneId;

    @Column(name = "ZNE_zone_name", nullable = false)
    private String zoneName;

    @Column(name = "ZNE_zone_base_price", nullable = false)
    private Double zoneBasePrice;

    @Column(name = "ZNE_zone_is_deleted", nullable = false)
    private Boolean zoneIsDeleted = false;

    public Zone(
            String zoneName,
            Double zoneBasePrice) {
        this.zoneName = zoneName;
        this.zoneBasePrice = zoneBasePrice;
    }
}
