package com.example.advert;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AdvertisementInMemoryRepository implements AdvertisementRepository {

    private List<Advertisement> advertisements;

    public AdvertisementInMemoryRepository() {
        this.advertisements = new ArrayList<>();

        byte[] image = new byte[0];
        try {
            File file = ResourceUtils.getFile("classpath:sandwich.jpg");
            image = FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            System.out.println("Error z plikiem");
        }

        this.advertisements.add(new Advertisement(1, "Samolot", "Jest bardzo duży!", 1000, image));
        this.advertisements.add(new Advertisement(2, "Kanapka", "Jest bardzo dobra!", 20, image));
        this.advertisements.add(new Advertisement(3, "Solnik", "Jest bardzo pyszny!", 5, image));
        this.advertisements.add(new Advertisement(4, "Babka piaskowa", "Jest bardzo piaskowa!", 15, image));
    }

    @Override
    public List<Advertisement> findAll() {
        return this.advertisements;
    }
}
