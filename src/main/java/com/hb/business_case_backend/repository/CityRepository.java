package com.hb.business_case_backend.repository;

import com.hb.business_case_backend.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CityRepository extends JpaRepository<City, UUID> {

    Optional<City> findByPostalCode(String postalCode);

}