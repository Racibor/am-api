package com.example.advert;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Advertisement {

    private long key;
    private String title;
    private String description;
    private double price;

}

