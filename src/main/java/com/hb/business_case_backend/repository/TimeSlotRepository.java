package com.hb.business_case_backend.repository;

import com.hb.business_case_backend.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, UUID> {
}