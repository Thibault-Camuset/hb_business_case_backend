package com.hb.business_case_backend.service;

import com.hb.business_case_backend.entity.Ad;
import com.hb.business_case_backend.entity.AdZoneTime;
import com.hb.business_case_backend.entity.TimeSlot;
import com.hb.business_case_backend.entity.Zone;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AdZoneTimeService {

    List<AdZoneTime> getAdZoneTimes();

    AdZoneTime getAdZoneTime(UUID dZoneTimeId);

    AdZoneTime createAdZoneTime(Ad ad, Zone zone, TimeSlot time, Double price);

    AdZoneTime updateAdZoneTime(UUID adZoneTimeId, Ad ad, Zone zone, TimeSlot time, Double price);

    boolean deleteAdZoneTime(UUID adZoneTimeId);

}
