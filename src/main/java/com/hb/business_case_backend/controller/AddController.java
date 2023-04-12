package com.hb.business_case_backend.controller;

import com.hb.business_case_backend.entity.Add;
import com.hb.business_case_backend.entity.User;
import com.hb.business_case_backend.service.AddService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/adds")
public class AddController {

    private AddService addService;

    @GetMapping("/{addId}")
    public Add addGet(@PathVariable UUID addId) {
        return addService.getAdd(addId);
    }

    @PostMapping("/{addTitle}/{addImage}/{addDescription}/{author}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Add addPost(
            @PathVariable String addTitle,
            @PathVariable String addImage,
            @PathVariable String addDescription,
            @PathVariable User author) {
        return addService.createAdd(addTitle, addImage, addDescription, author);
    }

    @PatchMapping("/{addId}/{addTitle}/{addImage}/{addDescription}/{author}")
    public Add addPatch(
            @PathVariable UUID addId,
            @PathVariable String addTitle,
            @PathVariable String addImage,
            @PathVariable String addDescription,
            @PathVariable User author) {
        return addService.updateAdd(addId, addTitle, addImage, addDescription, author);
    }

    @DeleteMapping("/{addId}")
    public boolean addDelete(@PathVariable UUID addId) {
        return addService.deleteAdd(addId);
    }

    @GetMapping("")
    public List<Add> addsGet() {
        return addService.getAdds();
    }

}
