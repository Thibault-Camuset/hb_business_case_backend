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
@Table(name = "STP_Stop")
public class Stop {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "STP_stop_id", nullable = false)
    private UUID stopId;

    @Column(name = "STP_stop_name", nullable = false)
    private String stopName;

    @JoinColumn(name = "ZNE_zone_id")
    @ManyToOne
    private Zone zone;

    @Column(name = "STP_raspberryIp", nullable = false)
    private String raspberryIp;

    public Stop(
            String stopName,
            Zone zone,
            String raspberryIp) {
        this.stopName = stopName;
        this.zone = zone;
        this.raspberryIp = raspberryIp;
    }

}
