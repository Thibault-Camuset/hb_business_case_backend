package com.hb.business_case_backend.controller;

import com.hb.business_case_backend.entity.City;
import com.hb.business_case_backend.entity.ZoneCity;
import com.hb.business_case_backend.entity.Zone;
import com.hb.business_case_backend.service.ZoneCityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/zoneCities")
public class ZoneCityController {

    private ZoneCityService zoneCityService;

    @GetMapping("/{zoneCityId}")
    public ZoneCity zoneCityGet(@PathVariable UUID zoneCityId) {
        return zoneCityService.getZoneCity(zoneCityId);
    }

    @PostMapping("/{zone}/{city}")
    @ResponseStatus(code= HttpStatus.CREATED)
    public ZoneCity zoneCityPost( @PathVariable Zone zone, @PathVariable City city) {
        return zoneCityService.createZoneCity(zone, city);
    }

    @PatchMapping("/{zoneCityId}/{zone}/{city}")
    public ZoneCity zoneCityPatch(@PathVariable UUID zoneCityId, @PathVariable Zone zone, @PathVariable City city) {
        return zoneCityService.updateZoneCity(zoneCityId, zone, city);
    }

    @DeleteMapping("/{zoneCityId}")
    public boolean zoneCityDelete(@PathVariable UUID zoneCityId) {
        return zoneCityService.deleteZoneCity(zoneCityId);
    }

    @GetMapping("")
    public List<ZoneCity> zoneCitiesGet() {
        return zoneCityService.getZoneCities();
    }

}
