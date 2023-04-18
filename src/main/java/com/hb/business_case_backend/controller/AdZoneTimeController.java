package com.hb.business_case_backend.controller;

import com.hb.business_case_backend.entity.Ad;
import com.hb.business_case_backend.entity.AdZoneTime;
import com.hb.business_case_backend.entity.TimeSlot;
import com.hb.business_case_backend.entity.Zone;
import com.hb.business_case_backend.service.AdService;
import com.hb.business_case_backend.service.AdZoneTimeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/adZoneTimes")
public class AdZoneTimeController {

    private AdZoneTimeService addZoneTimeService;
    private AdService adService;

    @GetMapping("/{adZoneTimeId}")
    public AdZoneTime adZoneTimeGet(@PathVariable UUID adZoneTimeId) {
        return addZoneTimeService.getAdZoneTime(adZoneTimeId);
    }

    @PostMapping("/{ad}/{zone}/{time}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AdZoneTime adZoneTimePost(
            @PathVariable Ad ad,
            @PathVariable Zone zone,
            @PathVariable TimeSlot time) {
        return addZoneTimeService.createAdZoneTime(ad, zone, time);
    }

    @PatchMapping("/{adZoneTimeId}/{ad}/{zone}/{time}")
    public AdZoneTime adZoneTimePatch(
            @PathVariable UUID adZoneTimeId,
            @PathVariable Ad ad,
            @PathVariable Zone zone,
            @PathVariable TimeSlot time) {
        return addZoneTimeService.updateAdZoneTime(adZoneTimeId, ad, zone, time);
    }

    @DeleteMapping("/{adZoneTimeId}")
    public boolean adZoneTimeDelete(@PathVariable UUID adZoneTimeId) {
        return addZoneTimeService.deleteAdZoneTime(adZoneTimeId);
    }

    @GetMapping("/byAdId/{adId}")
    public List<AdZoneTime> adZoneTimesGetByAdId(@PathVariable UUID adId) {

        System.out.println(adId);

        Ad ad = this.adService.getAd(adId);
        return addZoneTimeService.getAdZoneTimesByAd(ad);
    }

    @GetMapping("")
    public List<AdZoneTime> adZoneTimesGet() {
        return addZoneTimeService.getAdZoneTimes();
    }

}
