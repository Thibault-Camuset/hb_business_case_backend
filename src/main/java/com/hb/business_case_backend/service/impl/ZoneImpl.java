package com.hb.business_case_backend.service.impl;

import com.hb.business_case_backend.entity.Zone;
import com.hb.business_case_backend.repository.ZoneRepository;
import com.hb.business_case_backend.service.ZoneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ZoneImpl implements ZoneService {

    private final ZoneRepository zoneRepository;

    @Override
    public List<Zone> getZones() {
        List<Zone> zones = zoneRepository.findAll();
        zones.removeIf(zone -> zone.getZoneIsDeleted());
        return zones;
    }

    @Override
    public Zone getZone(UUID zoneId) {
        return zoneRepository.findById(zoneId).orElse(null);
    }

    @Override
    public Zone createZone(String zoneName, Double zoneBasePrice) {

        Zone zone = new Zone(zoneName, zoneBasePrice);
        return zoneRepository.save(zone);
    }

    @Override
    public Zone updateZone(UUID zoneId, String zoneName, Double zoneBasePrice) {

        Zone zone = zoneRepository.findById(zoneId).orElse(null);
        if (zone != null) {
            zone.setZoneName(zoneName);
            zone.setZoneBasePrice(zoneBasePrice);
        }
        return zoneRepository.save(zone);

    }

    @Override
    public boolean deleteZone(UUID zoneId) {

        Zone zone = zoneRepository.findById(zoneId).orElse(null);
        if (zone == null) {
            return false;
        } else {
            zone.setZoneIsDeleted(true);
            zoneRepository.save(zone);
            return true;
        }
    }
}
