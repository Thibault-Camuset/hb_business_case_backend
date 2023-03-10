package com.hb.business_case_backend.repository;

import com.hb.business_case_backend.entity.ZoneCity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ZoneCityRepository extends JpaRepository<ZoneCity, UUID> {
}