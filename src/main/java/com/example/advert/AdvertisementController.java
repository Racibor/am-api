package com.example.advert;

import com.example.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/advertisements")
public class AdvertisementController {

    private AdvertisementService advertisementService;
    private HttpSession httpSession;

    public AdvertisementController(AdvertisementService advertisementService, HttpSession httpSession) {
        this.advertisementService = advertisementService;
        this.httpSession = httpSession;
    }

    @GetMapping("/category")
    public List<Advertisement> getAllFiltered(@RequestParam(name = "name") String name){
        System.out.println("przyjęte");
        return advertisementService.findFromCategory(name);
    }

    @GetMapping()
    public List<Advertisement> getAll(){
        System.out.println("coś");
        User user = (User)httpSession.getAttribute("user");
        System.out.println("User registered: " + user.registered + " : " + user.login);
        return advertisementService.findAll();
    }

    @PostMapping("")
    public String add(@RequestBody Advertisement advertisement){
        Advertisement save = advertisementService.save(advertisement);
        User user = (User)httpSession.getAttribute("user");
        System.out.println("User registered: " + user.registered + " : " + user.login);
        return "Dodano obiekt: " + save;
    }

}
