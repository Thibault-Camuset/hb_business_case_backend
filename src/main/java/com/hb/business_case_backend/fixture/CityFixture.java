package com.hb.business_case_backend.fixture;

import com.hb.business_case_backend.entity.City;
import com.hb.business_case_backend.entity.Country;
import com.hb.business_case_backend.service.CityService;
import com.hb.business_case_backend.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class CityFixture {

    private CityService cityService;
    private CountryService countryService;

    public void addCities() {

        List<City> cities = cityService.getCities();

        if(cities.isEmpty()) {

            Country country = countryService.getCountry("FRA");

            cityService.createCity("63000", "Clermont-Ferrand", country);
            cityService.createCity("63400", "Chamalière", country);
        }

    }
}
