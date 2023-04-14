package com.hb.business_case_backend.service.impl;

import com.hb.business_case_backend.entity.Ad;
import com.hb.business_case_backend.entity.AdZoneTime;
import com.hb.business_case_backend.entity.TimeSlot;
import com.hb.business_case_backend.entity.Zone;
import com.hb.business_case_backend.repository.AdZoneTimeRepository;
import com.hb.business_case_backend.service.AdZoneTimeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AdZoneTimeImpl implements AdZoneTimeService {

    private final AdZoneTimeRepository adZoneTimeRepository;

    @Override
    public List<AdZoneTime> getAdZoneTimes() {
        return adZoneTimeRepository.findAll();
    }

    @Override
    public AdZoneTime getAdZoneTime(UUID cityId) {
        return adZoneTimeRepository.findById(cityId).orElse(null);
    }

    @Override
    public AdZoneTime createAdZoneTime(Ad ad, Zone zone, TimeSlot time, Double price) {

        AdZoneTime adZoneTime = new AdZoneTime(ad, zone, time, price);
        return adZoneTimeRepository.save(adZoneTime);
    }

    @Override
    public AdZoneTime updateAdZoneTime(UUID adZoneTimeId, Ad ad, Zone zone, TimeSlot time, Double price) {

        AdZoneTime adZoneTime = adZoneTimeRepository.findById(adZoneTimeId).orElse(null);
        if (adZoneTime != null) {
            adZoneTime.setAd(ad);
            adZoneTime.setZone(zone);
            adZoneTime.setTime(time);
            adZoneTime.setPrice(price);
        }
        return adZoneTimeRepository.save(adZoneTime);

    }

    @Override
    public boolean deleteAdZoneTime(UUID adZoneTimeId) {

        AdZoneTime adZoneTime = adZoneTimeRepository.findById(adZoneTimeId).orElse(null);
        if (adZoneTime == null) {
            return false;
        } else {
            adZoneTimeRepository.deleteById(adZoneTimeId);
            return true;
        }
    }
}
