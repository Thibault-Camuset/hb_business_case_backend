package com.hb.business_case_backend.service.impl;

import com.hb.business_case_backend.entity.City;
import com.hb.business_case_backend.entity.Stop;
import com.hb.business_case_backend.entity.Zone;
import com.hb.business_case_backend.entity.ZoneCity;
import com.hb.business_case_backend.repository.StopRepository;
import com.hb.business_case_backend.repository.ZoneCityRepository;
import com.hb.business_case_backend.service.ZoneCityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ZoneCityImpl implements ZoneCityService {

    private final ZoneCityRepository zoneCityRepository;

    @Override
    public List<ZoneCity> getZoneCities() {
        return zoneCityRepository.findAll();
    }

    @Override
    public ZoneCity getZoneCity(UUID zoneCityId) {
        return zoneCityRepository.findById(zoneCityId).orElse(null);
    }

    @Override
    public ZoneCity createZoneCity(Zone zone, City city) {
        ZoneCity zoneCity = new ZoneCity(zone, city);
        return zoneCityRepository.save(zoneCity);
    }

    @Override
    public ZoneCity updateZoneCity(UUID zoneCityId, Zone zone, City city) {
        ZoneCity zoneCity = zoneCityRepository.findById(zoneCityId).orElse(null);
        if(zoneCity != null) {
            zoneCity.setZone(zone);
            zoneCity.setCity(city);
        }
        return zoneCityRepository.save(zoneCity);
    }

    @Override
    public boolean deleteZoneCity(UUID zoneCityId) {
        ZoneCity zoneCity = zoneCityRepository.findById(zoneCityId).orElse(null);
        if(zoneCity == null) {
            return false;
        } else {
            zoneCityRepository.deleteById(zoneCityId);
            return true;
        }
    }
}
