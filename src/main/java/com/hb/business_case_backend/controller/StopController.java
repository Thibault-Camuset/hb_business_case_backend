package com.hb.business_case_backend.controller;

import com.hb.business_case_backend.entity.Stop;
import com.hb.business_case_backend.entity.Zone;
import com.hb.business_case_backend.service.StopService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/stops")
public class StopController {

    private StopService stopService;

    @GetMapping("/{stopId}")
    public Stop stopGet(@PathVariable UUID stopId) {
        return stopService.getStop(stopId);
    }

    @PostMapping("/{stopName}/{zone}/{raspberryIp}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Stop stopPost(
            @PathVariable String stopName,
            @PathVariable Zone zone,
            @PathVariable String raspberryIp) {
        return stopService.createStop(stopName, zone, raspberryIp);
    }

    @PatchMapping("/{stopId}/{stopName}/{zone}/{raspberryIp}")
    public Stop stopPatch(
            @PathVariable UUID stopId,
            @PathVariable String stopName,
            @PathVariable Zone zone,
            @PathVariable String raspberryIp) {
        return stopService.updateStop(stopId, stopName, zone, raspberryIp);
    }

    @DeleteMapping("/{stopId}")
    public boolean stopDelete(@PathVariable UUID stopId) {
        return stopService.deleteStop(stopId);
    }

    @GetMapping("")
    public List<Stop> stopsGet() {
        return stopService.getStops();
    }

}
