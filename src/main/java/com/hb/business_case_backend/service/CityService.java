package com.hb.business_case_backend.service;

import com.hb.business_case_backend.entity.City;
import com.hb.business_case_backend.entity.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CityService {

    List<City> getCities();

    City getCity(UUID cityId);

    City getCityByPostalCode(String postalCode);

    City createCity(String postalCode, String cityName, Country country);

    City updateCity(UUID cityId, String postalCode, String cityName, Country country);

    boolean deleteCity(UUID cityId);

}
