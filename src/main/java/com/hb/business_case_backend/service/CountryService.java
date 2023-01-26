package com.hb.business_case_backend.service;

import com.hb.business_case_backend.entity.Country;
import org.springframework.stereotype.Service;
import java.util.List;

// Interface qui propose les méthodes qui seront développées dans l'implémentation
@Service
public interface CountryService {

    List<Country> getCountries();

    Country getCountry(String id);

    Country createCountry(String id, String countryName);

    Country updateCountry(String id, String countryName);

    boolean deleteCountry(String id);
}
