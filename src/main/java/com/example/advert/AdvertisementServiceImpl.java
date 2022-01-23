package com.example.advert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<Advertisement> findFromCategory(String name) {
        return advertisementRepository.findAll().stream().filter(e -> e.getCategory().equals(name)).collect(Collectors.toList());
    }

    @Override
    public Advertisement save(Advertisement advertisement) {
        long key = advertisementRepository.findAll().size() + 1;
        Advertisement newAdvertisement = new Advertisement(
                advertisement.getUser(),
                key,
                advertisement.getTitle(),
                advertisement.getDescription(),
                advertisement.getPrice(),
                advertisement.getCategory(),
                advertisement.getBase64Image());
        advertisementRepository.save(newAdvertisement);
        return newAdvertisement;
    }
}
