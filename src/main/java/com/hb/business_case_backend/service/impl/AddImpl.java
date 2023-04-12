package com.hb.business_case_backend.service.impl;

import com.hb.business_case_backend.entity.Add;
import com.hb.business_case_backend.entity.User;
import com.hb.business_case_backend.repository.AddRepository;
import com.hb.business_case_backend.service.AddService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AddImpl implements AddService {

    private final AddRepository addRepository;

    @Override
    public List<Add> getAdds() {
        return addRepository.findAll();
    }

    @Override
    public Add getAdd(UUID addId) {
        return addRepository.findById(addId).orElse(null);
    }

    @Override
    public Add createAdd(String addTitle, String addImage, String addDescription, User author) {

        Add add = new Add(addTitle, addImage, addDescription, author);
        return addRepository.save(add);
    }

    @Override
    public Add updateAdd(UUID addId, String addTitle, String addImage, String addDescription, User author) {

        Add add = addRepository.findById(addId).orElse(null);
        if (add != null) {
            add.setAddTitle(addTitle);
            add.setAddImage(addImage);
            add.setAddDescription(addDescription);
            add.setAuthor(author);
        }
        return addRepository.save(add);

    }

    @Override
    public boolean deleteAdd(UUID addId) {

        Add add = addRepository.findById(addId).orElse(null);
        if (add == null) {
            return false;
        } else {
            addRepository.deleteById(addId);
            return true;
        }
    }
}
