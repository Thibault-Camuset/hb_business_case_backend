package com.hb.business_case_backend.fixture;

import com.hb.business_case_backend.entity.TimeSlot;
import com.hb.business_case_backend.service.TimeSlotService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Component
public class TimeSlotFixture {

    private TimeSlotService timeSlotService;

    public void addTimeSlots() {

        List<TimeSlot> timeSlots = timeSlotService.getTimeSlots();

        if (timeSlots.isEmpty()) {

            Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.HOUR_OF_DAY, 9);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            Date debut = calendar.getTime();

            calendar.set(Calendar.HOUR_OF_DAY, 17);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            Date fin = calendar.getTime();

            timeSlotService.createTimeSlot(
                    "Journée",
                    debut,
                    fin,
                    1.5);

        }

    }
}
