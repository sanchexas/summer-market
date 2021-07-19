package ru.geekbrains.summer.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.geekbrains.summer.market.model.Category;
import ru.geekbrains.summer.market.services.CategoryService;

@Controller
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("categories/{id}")
    @ResponseBody
    public Category showCategoryById(@PathVariable Long id) {
        return categoryService.findById(id).get();
    }
}
