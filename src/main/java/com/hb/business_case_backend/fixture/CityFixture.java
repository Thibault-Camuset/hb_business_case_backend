package com.hb.business_case_backend.fixture;

import com.hb.business_case_backend.entity.City;
import com.hb.business_case_backend.entity.Country;
import com.hb.business_case_backend.repository.CityRepository;
import com.hb.business_case_backend.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class CityFixture {

    private CityRepository cityRepository;
    private CountryRepository countryRepository;

    public void addCities() {

        List<City> cities = cityRepository.findAll();

        if(cities.isEmpty()) {

            Country country = countryRepository.findById("FRA").orElse(null);

            City city = new City("63000","Clermont-Ferrand",country);
            cityRepository.save(city);
            City city2 = new City("63400","Chamalières",country);
            cityRepository.save(city2);
        }

    }
}
