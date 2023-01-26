package com.hb.business_case_backend.repository;

import com.hb.business_case_backend.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Le répository dispose déjà des méthodes nécessaires à un CRUD basique grace à JPARepository
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}