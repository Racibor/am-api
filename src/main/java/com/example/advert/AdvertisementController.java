package com.example.advert;

import com.example.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowCredentials = "true")
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
        User user = (User)httpSession.getAttribute("user");
        System.out.println("User registered: " + user.registered + " : " + user.login);
        return advertisementService.findFromCategory(name);
    }

    @GetMapping()
    public List<Advertisement> getAll(){
        System.out.println("coś");
        User user = (User)httpSession.getAttribute("user");
        System.out.println("User registered: " + user.registered + " : " + user.login);
        return advertisementService.findAll();
    }

    @GetMapping("/mine")
    public List<Advertisement> getMine(){
        User user = (User)httpSession.getAttribute("user");
        System.out.println("mine adverts");
        System.out.println("User registered: " + user.registered + " : " + user.login);
        return advertisementService.findAll().stream().filter(e -> e.getUser().equals(user.login)).collect(Collectors.toList());
    }


    @PostMapping("")
    public String add(@RequestBody Advertisement advertisement){
        Advertisement save = advertisementService.save(advertisement);
        System.out.println(advertisement.getUser());
        System.out.println(advertisement.getBase64Image().toString().substring(0, 3));
        System.out.println("adding");
        User user = (User)httpSession.getAttribute("user");
        System.out.println("User registered: " + user.registered + " : " + user.login);
        return "Dodano obiekt: " + save;
    }

    @PutMapping("/edit")
    public String keepo(@RequestParam(name = "name") String key, @RequestBody Advertisement advertisement){
        Advertisement save = advertisementService.save(advertisement);
        System.out.println("edit");
        User user = (User)httpSession.getAttribute("user");
        System.out.println("User registered: " + user.registered + " : " + user.login);
        return "Dodano obiekt: " + save;
    }

}
