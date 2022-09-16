package io.knoldus.controller;

import io.knoldus.entity.Product;
import io.knoldus.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{productId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product getProduct(@PathVariable Long productId) {
        return productService.findByProductId(productId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody Product product, UriComponentsBuilder componentsBuilder) {
        productService.add(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.delete(productId);
    }
}
