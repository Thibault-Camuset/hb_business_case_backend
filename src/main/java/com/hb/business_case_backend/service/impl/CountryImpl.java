package com.hb.business_case_backend.service.impl;

import com.hb.business_case_backend.entity.Country;
import com.hb.business_case_backend.repository.CountryRepository;
import com.hb.business_case_backend.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryImpl implements CountryService {

    // Le repository que l'on va utiliser pour passer nos requêtes
    private final CountryRepository countryRepository;

    // Méthode pour récupérer la liste des pays
    @Override
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    // Méthode pour récupérer un pays
    @Override
    public Country getCountry(String id) {
        return countryRepository.findById(id).orElse(null);
    }

    // Méthode pour ajouter un nouveau pays
    @Override
    public Country createCountry(String id, String countryName) {

        Country country = new Country(id, countryName);
        return countryRepository.save(country);

    }

    // Méthode pour modifier le nom d'un pays
    @Override
    public Country updateCountry(String id, String countryName) {

        Country country = countryRepository.findById(id).orElse(null);

        if(country != null) {
            country.setCountryName(countryName);
        }

        return countryRepository.save(country);

    }

    // Méthode pour supprimer un pays
    @Override
    public boolean deleteCountry(String id) {

        Country country = countryRepository.findById(id).orElse(null);

        if(country == null) {
            return false;
        } else {
            countryRepository.deleteById(id);
            return true;
        }
    }

}
