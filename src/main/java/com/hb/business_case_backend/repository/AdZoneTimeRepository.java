package com.hb.business_case_backend.repository;

import com.hb.business_case_backend.entity.AdZoneTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdZoneTimeRepository extends JpaRepository<AdZoneTime, UUID> {
}