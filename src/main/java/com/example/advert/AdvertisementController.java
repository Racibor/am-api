package com.example.advert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/advertisements")
public class AdvertisementController {

    private AdvertisementService advertisementService;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }
    @GetMapping("/category")
    public List<Advertisement> getAllFiltered(@RequestParam(name = "name") String name){
        System.out.println("przyjęte");
        return advertisementService.findFromCategory(name);
    }

    @GetMapping()
    public List<Advertisement> getAll(){
        System.out.println("coś");
        return advertisementService.findAll();
    }

    @PostMapping
    public String add(@RequestBody Advertisement advertisement){
        Advertisement save = advertisementService.save(advertisement);
        return "Dodano obiekt: " + save;
    }

}
