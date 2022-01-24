package com.example.advert;

import java.util.List;

public interface AdvertisementService {

    List<Advertisement> findAll();
    List<Advertisement> findFromCategory(String name);
    Advertisement save(Advertisement advertisement);
    Advertisement update(Advertisement advertisement);

}
