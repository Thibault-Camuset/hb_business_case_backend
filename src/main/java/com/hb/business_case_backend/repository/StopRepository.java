package com.hb.business_case_backend.repository;

import com.hb.business_case_backend.entity.Stop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StopRepository extends JpaRepository<Stop, UUID> {
}