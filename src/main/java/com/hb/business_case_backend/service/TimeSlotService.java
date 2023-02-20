package com.hb.business_case_backend.service;

import com.hb.business_case_backend.entity.TimeSlot;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public interface TimeSlotService {

    List<TimeSlot> getTimeSlots();

    TimeSlot getTimeSlot(UUID timeSlotId);

    TimeSlot createTimeSlot(String timeSlotName, Date timeSlotStart, Date timeSlotEnd, Double timeSlotPriceMultiplier);

    TimeSlot updateTimeSlot(UUID timeSlotId, String timeSlotName, Date timeSlotStart, Date timeSlotEnd, Double timeSlotPriceMultiplier);

    boolean deleteTimeSlot(UUID timeSlotId);

}
