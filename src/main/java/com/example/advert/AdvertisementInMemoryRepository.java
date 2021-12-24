package com.example.advert;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AdvertisementInMemoryRepository implements AdvertisementRepository {

    private List<Advertisement> advertisements;

    public AdvertisementInMemoryRepository() {
        this.advertisements = new ArrayList<>();

        this.advertisements.add(new Advertisement(1, "Samolot", "Jest bardzo duży!", 1000));
        this.advertisements.add(new Advertisement(2, "Kanapka", "Jest bardzo dobra!", 20));
        this.advertisements.add(new Advertisement(3, "Solnik", "Jest bardzo pyszny!", 5));
        this.advertisements.add(new Advertisement(4, "Babka piaskowa", "Jest bardzo piaskowa!", 15));
    }

    @Override
    public List<Advertisement> findAll() {
        return this.advertisements;
    }
}
