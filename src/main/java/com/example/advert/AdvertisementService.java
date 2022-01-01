package com.example.advert;

import java.util.List;

public interface AdvertisementService {

    List<Advertisement> findAll();
    Advertisement save(Advertisement advertisement);

}
