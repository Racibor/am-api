package com.example.advert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/advertisements")
public class AdvertisementController {

    private AdvertisementService advertisementService;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @GetMapping
    public List<Advertisement> getAll(){
        return advertisementService.findAll();
    }

    @PostMapping
    public String add(@RequestBody Advertisement advertisement){
        Advertisement save = advertisementService.save(advertisement);
        return "Dodano obiekt: " + save;
    }

}
