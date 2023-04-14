package com.hb.business_case_backend.repository;

import com.hb.business_case_backend.entity.Ad;
import com.hb.business_case_backend.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AdRepository extends JpaRepository<Ad, UUID> {

    List<Ad> findByAuthor(User author);

}