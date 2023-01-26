package com.hb.business_case_backend.service.impl;

import com.hb.business_case_backend.entity.City;
import com.hb.business_case_backend.entity.Country;
import com.hb.business_case_backend.repository.CityRepository;
import com.hb.business_case_backend.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CityImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<City> getCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCity(UUID cityId) {
        return cityRepository.findById(cityId).orElse(null);
    }

    @Override
    public City createCity(String postalCode, String cityName, Country country) {

        City city = new City(postalCode,cityName, country);
        return cityRepository.save(city);
    }

    @Override
    public City updateCity(UUID cityId, String postalCode, String cityName, Country country) {

        City city = cityRepository.findById(cityId).orElse(null);
        if(city != null) {
            city.setPostalCode(postalCode);
            city.setCityName(cityName);
            city.setCountry(country);
        }
        return cityRepository.save(city);

    }

    @Override
    public boolean deleteCity(UUID cityId) {

        City city = cityRepository.findById(cityId).orElse(null);
        if(city == null) {
            return false;
        } else {
            cityRepository.deleteById(cityId);
            return true;
        }
    }
}
