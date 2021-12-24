package com.example.advert;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Advertisement {

    private final long key;
    private final String title;
    private final String description;
    private final double price;

}

