package com.hb.business_case_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "TMS_Time_Slot")

public class TimeSlot {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "TMS_time_slot_id", nullable = false)
    private UUID timeSlotId;

    @Column(name = "TMS_time_slot_name", nullable = false, length = 255)
    private String timeSlotName;

    @Column(name = "TMS_time_slot_start", nullable = false, length = 255)
    private Date timeSlotStart;

    @Column(name = "TMS_time_slot_end", nullable = false, length = 255)
    private Date timeSlotEnd;

    @Column(name = "TMS_time_slot_price_multiplier", nullable = false, length = 255)
    private Double timeSlotPriceMultiplier;

    public TimeSlot(String timeSlotName, Date timeSlotStart, Date timeSlotEnd, Double timeSlotPriceMultiplier) {
        this.timeSlotName = timeSlotName;
        this.timeSlotStart = timeSlotStart;
        this.timeSlotEnd = timeSlotEnd;
        this.timeSlotPriceMultiplier = timeSlotPriceMultiplier;
    }

}
