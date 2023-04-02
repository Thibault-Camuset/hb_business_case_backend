package com.hb.business_case_backend.controller;

import com.hb.business_case_backend.entity.Country;
import com.hb.business_case_backend.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/countries")
public class CountryController {

    private CountryService countryService;

    // Route pour récupérer un pays
    @GetMapping("/{id}")
    public Country countryGet(@PathVariable String id) {
        return countryService.getCountry(id);
    }

    // Route pour ajouter un nouveau pays
    @PostMapping("/{id}/{countryName}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Country countryPost(@PathVariable String id, @PathVariable String countryName) {
        return countryService.createCountry(id, countryName);
    }

    // Route pour modifier un pays
    @PatchMapping("/{id}/{countryName}")
    public Country countryPatch(@PathVariable String id, @PathVariable String countryName) {
        return countryService.updateCountry(id, countryName);
    }

    // Route pour supprimer un pays
    @DeleteMapping("/{id}")
    public boolean countryDelete(@PathVariable String id) {
        return countryService.deleteCountry(id);
    }

    // Route pour récupérer la liste des pays
    @GetMapping("")
    public List<Country> countriesGet() {
        return countryService.getCountries();
    }
}
