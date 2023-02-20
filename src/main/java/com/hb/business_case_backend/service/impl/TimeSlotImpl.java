package com.hb.business_case_backend.service.impl;

import com.hb.business_case_backend.entity.TimeSlot;
import com.hb.business_case_backend.repository.TimeSlotRepository;
import com.hb.business_case_backend.service.TimeSlotService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TimeSlotImpl implements TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;

    @Override
    public List<TimeSlot> getTimeSlots() {
        return timeSlotRepository.findAll();
    }

    @Override
    public TimeSlot getTimeSlot(UUID timeSlotId) {
        return timeSlotRepository.findById(timeSlotId).orElse(null);
    }

    @Override
    public TimeSlot createTimeSlot(String timeSlotName, Date timeSlotStart, Date timeSlotEnd, Double timeSlotPriceMultiplier) {
        TimeSlot timeSlot = new TimeSlot(timeSlotName, timeSlotStart, timeSlotEnd, timeSlotPriceMultiplier);
        return timeSlotRepository.save(timeSlot);
    }

    @Override
    public TimeSlot updateTimeSlot(UUID timeSlotId, String timeSlotName, Date timeSlotStart, Date timeSlotEnd, Double timeSlotPriceMultiplier) {
       TimeSlot timeSlot = timeSlotRepository.findById(timeSlotId).orElse(null);
        if(timeSlot != null) {
            timeSlot.setTimeSlotName(timeSlotName);
            timeSlot.setTimeSlotStart(timeSlotStart);
            timeSlot.setTimeSlotEnd(timeSlotEnd);
            timeSlot.setTimeSlotPriceMultiplier(timeSlotPriceMultiplier);
        }
        return timeSlotRepository.save(timeSlot);
    }

    @Override
    public boolean deleteTimeSlot(UUID timeSlotId) {
        TimeSlot timeSlot = timeSlotRepository.findById(timeSlotId).orElse(null);
        if(timeSlot == null) {
            return false;
        } else {
            timeSlotRepository.deleteById(timeSlotId);
            return true;
        }
    }
}
