package com.example.advert;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class AdvertisementInMemoryRepository implements AdvertisementRepository {

    private Map<Long,Advertisement> advertisements;

    public AdvertisementInMemoryRepository() {
        this.advertisements = new HashMap<>();

        byte[] image = new byte[0];
        try {
            File file = ResourceUtils.getFile("classpath:samolot.jpg");
            image = FileUtils.readFileToByteArray(file);

            this.advertisements.put(1L, new Advertisement("przemo",1, "Samolot", "Jest bardzo duży!", 1000, "Elektronika",image));

            file = ResourceUtils.getFile("classpath:sandwich.jpg");
            image = FileUtils.readFileToByteArray(file);

            this.advertisements.put(2L, new Advertisement("przemo",2, "Kanapka", "Jest bardzo dobra!", 20, "Motoryzacja",image));

            file = ResourceUtils.getFile("classpath:solnik.jpg");
            image = FileUtils.readFileToByteArray(file);

            this.advertisements.put(3L, new Advertisement("ala",3, "Solnik", "Jest bardzo pyszny!", 5, "Elektronika",image));

            file = ResourceUtils.getFile("classpath:babka.jpg");
            image = FileUtils.readFileToByteArray(file);

            this.advertisements.put(4L, new Advertisement("ala",4, "Babka piaskowa", "Jest bardzo piaskowa!", 15, "Odzież",image));

        } catch (IOException e) {
            System.out.println("Error z plikiem");
        }

    }

    @Override
    public List<Advertisement> findAll() {
        return this.advertisements.values().stream().collect(Collectors.toList());
    }

    @Override
    public void save(Advertisement advertisement) {
        this.advertisements.put(advertisement.getKey(), advertisement);
    }

    @Override
    public Advertisement update(Advertisement advertisement) {
        return this.advertisements.put(advertisement.getKey(), advertisement);
    }
}
