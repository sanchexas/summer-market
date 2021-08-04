package ru.geekbrains.summer.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.summer.market.exceptions.ResourceNotFoundException;
import ru.geekbrains.summer.market.services.ProductService;
import ru.geekbrains.summer.market.utils.Cart;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final Cart cart;
    private final ProductService productService;

    @GetMapping
    public Cart getCart() {
        return cart;
    }


//    @GetMapping("/add/{productId}")
//    public void add(@PathVariable Long productId) {
//        Product p = productService.findById(productId).orElseThrow(()->new ResourceNotFoundException
//                ("Unable add product to cart. Product not found id: \" + productId"));
//        cart.add(p);
//    }
    @GetMapping("/add/{productId}")
    public void add(@PathVariable Long productId) {
        if (!cart.add(productId)) {
            cart.add(productService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Unable add product to cart. Product not found id: " + productId)));
        }

    }
    @GetMapping("/empty_cart")
    public void clear(){
        cart.clear();
    }
//    @GetMapping("/delete_product{id}")
//    public void delete(@PathVariable Long id){
//        cart.clear(productService.deleteById(id));
//    }
}
