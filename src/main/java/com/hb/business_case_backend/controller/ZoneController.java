package com.hb.business_case_backend.controller;

import com.hb.business_case_backend.entity.Zone;
import com.hb.business_case_backend.service.ZoneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/zones")
public class ZoneController {

    private ZoneService zoneService;

    @GetMapping("/{zoneId}")
    public Zone zoneGet(@PathVariable UUID zoneId) {
        return zoneService.getZone(zoneId);
    }

    @PostMapping("/{zoneName}/{zoneBasePrice}")
    @ResponseStatus(code= HttpStatus.CREATED)
    public Zone zonePost(@PathVariable String zoneName, @PathVariable Double zoneBasePrice) {
        return zoneService.createZone(zoneName, zoneBasePrice);
    }

    @PatchMapping("/{zoneId}/{zoneName}/{zoneBasePrice}")
    public Zone zonePatch(@PathVariable UUID zoneId, @PathVariable String zoneName, @PathVariable Double zoneBasePrice) {
        return zoneService.updateZone(zoneId, zoneName, zoneBasePrice);
    }

    @DeleteMapping("/{zoneId}")
    public boolean zoneDelete(@PathVariable UUID zoneId) {
        return zoneService.deleteZone(zoneId);
    }

    @GetMapping("")
    public List<Zone> citiesGet() {
        return zoneService.getZones();
    }

}
