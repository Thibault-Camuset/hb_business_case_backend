package com.hb.business_case_backend.fixture;

import com.hb.business_case_backend.entity.Country;
import com.hb.business_case_backend.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class CountryFixture {

    private CountryService countryService;

    public void addCountries() {

        List<Country> countries = countryService.getCountries();

        if (countries.isEmpty()) {
            countryService.createCountry("FRA", "France");
            countryService.createCountry("BE / BEL", "Belgique");
            countryService.createCountry("LU / LUX", "Luxembourg");
            countryService.createCountry("CH / CHE", "Suisse");
            countryService.createCountry("MC / MCO", "Monaco");
        }

    }
}
