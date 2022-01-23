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
            File file = ResourceUtils.getFile("classpath:samolot.jpg");
            image = FileUtils.readFileToByteArray(file);

            this.advertisements.add(new Advertisement("przemo",1, "Samolot", "Jest bardzo duży!", 1000, "Elektronika",image));

            file = ResourceUtils.getFile("classpath:sandwich.jpg");
            image = FileUtils.readFileToByteArray(file);

            this.advertisements.add(new Advertisement("przemo",2, "Kanapka", "Jest bardzo dobra!", 20, "Motoryzacja",image));

            file = ResourceUtils.getFile("classpath:solnik.jpg");
            image = FileUtils.readFileToByteArray(file);

            this.advertisements.add(new Advertisement("ala",3, "Solnik", "Jest bardzo pyszny!", 5, "Elektronika",image));

            file = ResourceUtils.getFile("classpath:babka.jpg");
            image = FileUtils.readFileToByteArray(file);

            this.advertisements.add(new Advertisement("ala",4, "Babka piaskowa", "Jest bardzo piaskowa!", 15, "Odzież",image));

        } catch (IOException e) {
            System.out.println("Error z plikiem");
        }

    }

    @Override
    public List<Advertisement> findAll() {
        return this.advertisements;
    }

    @Override
    public void save(Advertisement advertisement) {
        this.advertisements.add(advertisement);
    }
}
