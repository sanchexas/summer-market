package ru.geekbrains.summer.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.summer.market.dto.ProductDto;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.services.ProductService;
import ru.geekbrains.summer.market.exceptions.ResourceNotFoundException;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    // GET http://localhost:8189/summer
   @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id){
       Product p = productService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found, id: " + id));
       return new ProductDto(p);

    }

    @GetMapping
    public Page<ProductDto> findAllProducts(@RequestParam(name = "p", defaultValue = "1") int pageIndex){
        return productService.findPage(pageIndex -1,5).map(ProductDto::new);
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
