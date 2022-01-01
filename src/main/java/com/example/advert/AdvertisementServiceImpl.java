package com.example.advert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService{

    AdvertisementRepository advertisementRepository;

    @Autowired
    public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    @Override
    public List<Advertisement> findAll() {
        return this.advertisementRepository.findAll();
    }

    @Override
    public Advertisement save(Advertisement advertisement) {
        long key = advertisementRepository.findAll().size() + 1;
        Advertisement newAdvertisement = new Advertisement(
                key,
                advertisement.getTitle(),
                advertisement.getDescription(),
                advertisement.getPrice(),
                advertisement.getBase64Image());
        advertisementRepository.save(newAdvertisement);
        return newAdvertisement;
    }
}
