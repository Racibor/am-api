package com.example.advert;

import java.util.List;

public interface AdvertisementRepository {

    List<Advertisement> findAll();
    void save(Advertisement advertisement);
    Advertisement update(Advertisement advertisement);
}
