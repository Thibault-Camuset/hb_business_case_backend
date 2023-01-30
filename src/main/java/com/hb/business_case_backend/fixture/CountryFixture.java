package com.hb.business_case_backend.fixture;

import com.hb.business_case_backend.entity.Country;
import com.hb.business_case_backend.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class CountryFixture {

    private CountryRepository countryRepository;

    public void addCountries() {

        List<Country> countries = countryRepository.findAll();

        if(countries.isEmpty()) {
            Country country = new Country("FRA","France");
            countryRepository.save(country);
            Country country2 = new Country("BE / BEL","Belgique");
            countryRepository.save(country2);
            Country country3 = new Country("LU / LUX","Luxembourg");
            countryRepository.save(country3);
            Country country4 = new Country("CH / CHE","Suisse");
            countryRepository.save(country4);
            Country country5 = new Country("MC / MCO","Monaco");
            countryRepository.save(country5);
        }

    }
}
