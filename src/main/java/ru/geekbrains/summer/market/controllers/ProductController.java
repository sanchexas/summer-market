package ru.geekbrains.summer.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.summer.market.dto.ProductDto;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.services.ProductService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    // GET http://localhost:8189/summer
   @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id){
        return new ProductDto(productService.findById(id));
    }

    @GetMapping
    public Page<Product> findAllProducts(@RequestParam(name = "p", defaultValue = "1") int pageIndex){
        return productService.findPage(-1,5);
    }

    @PostMapping
    public ProductDto createNewProduct(@RequestBody ProductDto newProductDto) {
        Product product = new Product();
        product.setPrice(newProductDto.getPrice());
        product.setTitle(newProductDto.getTitle());
        return new ProductDto(productService.save(product));
    }


    @DeleteMapping("/remove_product/{id}")
    public void deleteProductById(@PathVariable Long id){
       productService.deleteById(id);
    }

}
