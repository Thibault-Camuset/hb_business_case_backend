package com.hb.business_case_backend.service;

import com.hb.business_case_backend.entity.Add;
import com.hb.business_case_backend.entity.User;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AddService {

    List<Add> getAdds();

    Add getAdd(UUID addId);

    Add createAdd(String addTitle, String addImage, String addDescription, User author);

    Add updateAdd(UUID addId, String addTitle, String addImage, String addDescription, User author);

    boolean deleteAdd(UUID addId);

}
