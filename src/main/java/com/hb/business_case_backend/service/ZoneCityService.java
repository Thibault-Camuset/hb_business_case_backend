package com.hb.business_case_backend.service;

import com.hb.business_case_backend.entity.City;
import com.hb.business_case_backend.entity.ZoneCity;
import com.hb.business_case_backend.entity.Zone;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ZoneCityService {

    List<ZoneCity> getZoneCities();

    ZoneCity getZoneCity(UUID zoneCityId);

    ZoneCity createZoneCity(Zone zone, City city);

    ZoneCity updateZoneCity(UUID zoneCityId, Zone zone, City city);

    boolean deleteZoneCity(UUID zoneCityId);
}
