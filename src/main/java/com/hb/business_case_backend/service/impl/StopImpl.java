package com.hb.business_case_backend.service.impl;

import com.hb.business_case_backend.entity.Stop;
import com.hb.business_case_backend.entity.Zone;
import com.hb.business_case_backend.repository.StopRepository;
import com.hb.business_case_backend.service.StopService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StopImpl implements StopService {

    private final StopRepository stopRepository;

    @Override
    public List<Stop> getStops() {
        return stopRepository.findAll();
    }

    @Override
    public Stop getStop(UUID stopId) {
        return stopRepository.findById(stopId).orElse(null);
    }

    @Override
    public Stop createStop(String stopName, Zone zone, String raspberryIp) {
        Stop stop = new Stop(stopName, zone, raspberryIp);
        return stopRepository.save(stop);
    }

    @Override
    public Stop updateStop(UUID stopId, String stopName, Zone zone, String raspberryIp) {
        Stop stop = stopRepository.findById(stopId).orElse(null);
        if(stop != null) {
            stop.setStopName(stopName);
            stop.setZone(zone);
            stop.setRaspberryIp(raspberryIp);
        }
        return stopRepository.save(stop);
    }

    @Override
    public boolean deleteStop(UUID stopId) {
        Stop stop = stopRepository.findById(stopId).orElse(null);
        if(stop == null) {
            return false;
        } else {
            stopRepository.deleteById(stopId);
            return true;
        }
    }
}
