package com.hb.business_case_backend.fixture;

import com.hb.business_case_backend.entity.City;
import com.hb.business_case_backend.entity.Zone;
import com.hb.business_case_backend.service.CityService;
import com.hb.business_case_backend.service.ZoneCityService;
import com.hb.business_case_backend.service.ZoneService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ZoneFixture {

    private CityService cityService;
    private ZoneService zoneService;
    private ZoneCityService zoneCityService;

    public void addZones() {

        List<Zone> zones = zoneService.getZones();

        if (zones.isEmpty()) {

            City clermont = cityService.getCityByPostalCode("63000");
            City chamaliere = cityService.getCityByPostalCode("63400");

            Zone zone1 = zoneService.createZone("Centre-Ville", 250.00);
            zoneCityService.createZoneCity(zone1, clermont);

            Zone zone2 = zoneService.createZone("Salins", 150.00);
            zoneCityService.createZoneCity(zone2, clermont);

            Zone zone3 = zoneService.createZone("Delille", 150.00);
            zoneCityService.createZoneCity(zone3, clermont);

            Zone zone4 = zoneService.createZone("Nord", 90.00);
            zoneCityService.createZoneCity(zone4, clermont);

            Zone zone5 = zoneService.createZone("Chamalière", 80.00);
            zoneCityService.createZoneCity(zone5, chamaliere);

        }

    }
}
