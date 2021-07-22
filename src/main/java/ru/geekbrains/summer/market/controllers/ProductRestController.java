package ru.geekbrains.summer.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.services.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductService productService;

    // GET http://localhost:8189/summer
   @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return productService.findAll();
    }
// http://localhost:8189/summer/products/page?p=1
    @GetMapping("/products_page")
    public Page<Product> findProductPage(@RequestParam(name = "p") int pageIndex){
        return productService.findPage(-1,5);
    }



//---
    @PostMapping("/remove_product/{id}")
    public String removeProductFromList(Model model,@PathVariable Long id) {
        model.addAttribute(productService.removeProductFromList(id));
        return "redirect:/";
    }

//---
}
