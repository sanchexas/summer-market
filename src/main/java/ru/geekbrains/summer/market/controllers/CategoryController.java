package ru.geekbrains.summer.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.summer.market.dto.CategoryDto;
import ru.geekbrains.summer.market.dto.ProductDto;
import ru.geekbrains.summer.market.model.Category;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.repositories.CategoryRepository;
import ru.geekbrains.summer.market.services.CategoryService;
import ru.geekbrains.summer.market.services.ProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable Long id) {
        return new CategoryDto(categoryService.findById(id));
    }
}
