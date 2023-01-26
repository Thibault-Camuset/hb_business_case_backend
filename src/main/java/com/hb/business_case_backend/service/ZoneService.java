package com.hb.business_case_backend.service;

import com.hb.business_case_backend.entity.Zone;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ZoneService {

    List<Zone> getZones();

    Zone getZone(UUID zoneId);

    Zone createZone(String zoneName, Double zoneBasePrice);

    Zone updateZone(UUID zoneId, String zoneName, Double zoneBasePrice);

    boolean deleteZone(UUID zoneId);

}
