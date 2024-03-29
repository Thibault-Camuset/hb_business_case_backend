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
    private RoleFixture roleFixture;
    private UserFixture userFixture;
    private ZoneFixture zoneFixture;
    private TimeSlotFixture timeSlotFixture;

    @EventListener(ApplicationReadyEvent.class)
    public void loadInitialData() {

        this.countryFixture.addCountries();
        this.cityFixture.addCities();
        this.roleFixture.addRoles();
        this.userFixture.addUsers();
        this.zoneFixture.addZones();
        this.timeSlotFixture.addTimeSlots();
    }

}
