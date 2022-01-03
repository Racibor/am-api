package com.example.category;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CategoryInMemoryRepository implements CategoryRepository {
    private Map<String, Category> categories;

    public CategoryInMemoryRepository() {
        this.categories = new HashMap<>();
        this.categories.put("elektronika", new Category("Elektronika", 1));
        this.categories.put("odzież", new Category("Odzież", 2));
        this.categories.put("motoryzacja", new Category("Motoryzacja", 3));
    }

    @Override
    public List<Category> getCategories() {
        return categories.values().stream().collect(Collectors.toList());
    }
}
