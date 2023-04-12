package com.hb.business_case_backend.controller;

import com.hb.business_case_backend.entity.City;
import com.hb.business_case_backend.entity.Country;
import com.hb.business_case_backend.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/cities")
public class CityController {

    private CityService cityService;

    @GetMapping("/{cityId}")
    public City cityGet(@PathVariable UUID cityId) {
        return cityService.getCity(cityId);
    }

    @PostMapping("/{postalCode}/{cityName}/{country}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public City cityPost(@PathVariable String postalCode, @PathVariable String cityName,
            @PathVariable Country country) {
        return cityService.createCity(postalCode, cityName, country);
    }

    @PatchMapping("/{cityId}/{postalCode}/{cityName}/{country}")
    public City cityPatch(@PathVariable UUID cityId, @PathVariable String postalCode, @PathVariable String cityName,
            @PathVariable Country country) {
        return cityService.updateCity(cityId, postalCode, cityName, country);
    }

    @DeleteMapping("/{cityId}")
    public boolean cityDelete(@PathVariable UUID cityId) {
        return cityService.deleteCity(cityId);
    }

    @GetMapping("")
    public List<City> citiesGet() {
        return cityService.getCities();
    }

}
