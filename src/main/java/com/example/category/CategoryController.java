package com.example.category;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController("/categories")
public class CategoryController {

    CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public List<Category> getCategories() {
        System.out.println("cos");
        return categoryRepository.getCategories();
    }
}
