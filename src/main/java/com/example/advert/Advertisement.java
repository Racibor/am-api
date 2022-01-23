package com.example.advert;

import com.example.security.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@RequiredArgsConstructor
public class Advertisement {
    private final String user;
    private final long key;
    private final String title;
    private final String description;
    private final double price;
    private final String category;
    private final byte[] base64Image;
}

