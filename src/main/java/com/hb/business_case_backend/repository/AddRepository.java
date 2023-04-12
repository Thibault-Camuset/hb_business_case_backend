package com.hb.business_case_backend.repository;

import com.hb.business_case_backend.entity.Add;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddRepository extends JpaRepository<Add, UUID> {
}