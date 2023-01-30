package com.hb.business_case_backend.fixture;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LoadData {

    private CountryFixture countryFixture;
    private CityFixture cityFixture;

    @EventListener(ApplicationReadyEvent.class)
    public void loadInitialData() {
        this.countryFixture.addCountries();
        this.cityFixture.addCities();
    }

}
