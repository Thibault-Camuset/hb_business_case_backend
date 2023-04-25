package com.hb.business_case_backend.controller;

import com.hb.business_case_backend.entity.TimeSlot;
import com.hb.business_case_backend.service.TimeSlotService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/timeSlots")
public class TimeSlotController {

    private TimeSlotService timeSlotService;

    @GetMapping("/{timeSlotId}")
    public TimeSlot timeSlotGet(@PathVariable UUID timeSlotId) {
        return timeSlotService.getTimeSlot(timeSlotId);
    }

    @PostMapping("/{timeSlotName}/{timeSlotStart}/{timeSlotEnd}/{timeSlotPriceMultiplier}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public TimeSlot timeSlotPost(
            @PathVariable String timeSlotName,
            @PathVariable Date timeSlotStart,
            @PathVariable Date timeSlotEnd,
            @PathVariable Double timeSlotPriceMultiplier) {
        return timeSlotService.createTimeSlot(timeSlotName, timeSlotStart, timeSlotEnd, timeSlotPriceMultiplier);
    }

    @PatchMapping("/{timeSlotId}/{timeSlotName}/{timeSlotStart}/{timeSlotEnd}/{timeSlotPriceMultiplier}")
    public TimeSlot timeSlotPatch(
            @PathVariable UUID timeSlotId,
            @PathVariable String timeSlotName,
            @PathVariable Date timeSlotStart,
            @PathVariable Date timeSlotEnd,
            @PathVariable Double timeSlotPriceMultiplier) {
        return timeSlotService.updateTimeSlot(timeSlotId, timeSlotName, timeSlotStart, timeSlotEnd,
                timeSlotPriceMultiplier);
    }

    @DeleteMapping("/{timeSlotId}")
    public boolean timeSlotDelete(@PathVariable UUID timeSlotId) {
        return timeSlotService.deleteTimeSlot(timeSlotId);
    }

    @GetMapping("")
    public List<TimeSlot> timeSlotsGet() {
        return timeSlotService.getTimeSlots();
    }

}
