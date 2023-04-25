package com.hb.business_case_backend.service.impl;

import com.hb.business_case_backend.entity.Ad;
import com.hb.business_case_backend.entity.User;
import com.hb.business_case_backend.repository.AdRepository;
import com.hb.business_case_backend.repository.UserRepository;
import com.hb.business_case_backend.service.AdService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AdImpl implements AdService {

    private final AdRepository adRepository;
    private final UserRepository userRepository;

    @Override
    public List<Ad> getAds() {
        return adRepository.findAll();
    }

    @Override
    public List<Ad> getAdsByUser(String userEmail) {

        Optional<User> user = userRepository.findByUserEmail(userEmail);
        if (user.isPresent() && user.get().getUserRole().getRoleName().equals("ADMIN")) {
            return adRepository.findAll();
        } else {
            return adRepository.findByAuthor(user.get());
        }
    }

    @Override
    public Ad getAd(UUID adId) {
        return adRepository.findById(adId).orElse(null);
    }

    @Override
    public Ad createAd(
            String adTitle,
            String adImage,
            String adDescription,
            User author) {

        Ad ad = new Ad(adTitle, adImage, adDescription, author);
        ad.setAdStatus("Pending");
        return adRepository.save(ad);
    }

    @Override
    public Ad updateAd(
            UUID adId,
            String adTitle,
            String adImage,
            String adDescription,
            User author) {

        Ad ad = adRepository.findById(adId).orElse(null);
        if (ad != null) {
            ad.setAdTitle(adTitle);
            ad.setAdImage(adImage);
            ad.setAdDescription(adDescription);
            ad.setAuthor(author);
        }
        return adRepository.save(ad);
    }

    @Override
    public boolean deleteAd(UUID adId) {

        Ad ad = adRepository.findById(adId).orElse(null);
        if (ad == null) {
            return false;
        } else {
            ad.setAdIsDeleted(true);
            ad.setAdStatus("Cancelled");
            adRepository.save(ad);
            return true;
        }
    }

    @Override
    public boolean validateAd(UUID adId) {

        Ad ad = adRepository.findById(adId).orElse(null);
        if (ad == null) {
            return false;
        } else {
            ad.setAdStatus("Accepted");
            adRepository.save(ad);
            return true;
        }
    }
}
