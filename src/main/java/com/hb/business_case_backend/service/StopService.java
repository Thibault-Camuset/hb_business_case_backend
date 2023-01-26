package com.hb.business_case_backend.service;

import com.hb.business_case_backend.entity.Stop;
import com.hb.business_case_backend.entity.Zone;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface StopService {

    List<Stop> getStops();

    Stop getStop(UUID stopId);

    Stop createStop(String stopName, Zone zone, String raspberryIp);

    Stop updateStop(UUID stopId, String stopName, Zone zone, String raspberryIp);

    boolean deleteStop(UUID stopId);

}
