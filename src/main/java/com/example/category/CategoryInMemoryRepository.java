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
        this.categories.put("elektronika", new Category("elektronika"));
        this.categories.put("odzież", new Category("odzież"));
    }

    @Override
    public List<Category> getCategories() {
        return categories.values().stream().collect(Collectors.toList());
    }
}
