package ru.geekbrains.summer.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.services.ProductService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RestController {
    private final ProductService productService;



    @GetMapping("products/{id}")
    @ResponseBody
    public Product showProductById(@PathVariable Long id) {
        return productService.findById(id).get();
    }

}
