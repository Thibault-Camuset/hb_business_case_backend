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
@Table(name = "AZT_Ad_Zone_Time")
public class AdZoneTime {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "AZT_ad_zone_time_id", nullable = false)
    private UUID adZoneTimeId;

    @Column(name = "AZT_price", nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "AZT_ad_id")
    private Ad ad;

    @ManyToOne
    @JoinColumn(name = "AZT_zone_id")
    private Zone zone;

    @ManyToOne
    @JoinColumn(name = "AZT_time_id")
    private TimeSlot time;

    public AdZoneTime(Ad ad, Zone zone, TimeSlot time, Double price) {
        this.ad = ad;
        this.zone = zone;
        this.time = time;
        this.price = price;
    }
}
