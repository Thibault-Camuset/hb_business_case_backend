package com.hb.business_case_backend.service;

import com.hb.business_case_backend.entity.Ad;
import com.hb.business_case_backend.entity.User;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AdService {

    List<Ad> getAds();

    List<Ad> getAdsByUser(String userEmail);

    Ad getAd(UUID adId);

    Ad createAd(String adTitle, String adImage, String adDescription, User author);

    Ad updateAd(UUID adId, String adTitle, String adImage, String adDescription, User author);

    boolean deleteAd(UUID adId);

}
