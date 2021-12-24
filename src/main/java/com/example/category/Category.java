package com.example.category;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Category {
    private final String name;
    private final long key;
}
