package com.hb.business_case_backend.controller;

import com.hb.business_case_backend.entity.Ad;
import com.hb.business_case_backend.entity.User;
import com.hb.business_case_backend.service.AdService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/ads")
public class AdController {

    private AdService adService;

    @GetMapping("/{adId}")
    public Ad addGet(@PathVariable UUID adId) {
        return adService.getAd(adId);
    }

    @PostMapping("/{adTitle}/{adDescription}/{author}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Ad adPost(
            @PathVariable String adTitle,
            @PathVariable String adDescription,
            @PathVariable User author,
            @RequestParam String adImage) {
        return adService.createAd(adTitle, adImage, adDescription, author);
    }

    @PatchMapping("/{adId}/{adTitle}/{adImage}/{adDescription}/{author}")
    public Ad adPatch(
            @PathVariable UUID adId,
            @PathVariable String adTitle,
            @PathVariable String adImage,
            @PathVariable String adDescription,
            @PathVariable User author) {
        return adService.updateAd(adId, adTitle, adImage, adDescription, author);
    }

    @DeleteMapping("/{adId}")
    public boolean addDelete(@PathVariable UUID adId) {
        return adService.deleteAd(adId);
    }

    @GetMapping("/accept/{adId}")
    public boolean validateAd(@PathVariable UUID adId) {
        return adService.validateAd(adId);
    }

    @GetMapping("/byUser/{userEmail}")
    public List<Ad> adsGetByUser(@PathVariable String userEmail) {
        return adService.getAdsByUser(userEmail);
    }

    @GetMapping("")
    public List<Ad> adsGet() {
        return adService.getAds();
    }

}
