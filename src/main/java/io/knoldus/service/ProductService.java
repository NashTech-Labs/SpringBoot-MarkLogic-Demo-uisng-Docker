package io.knoldus.service;

import io.knoldus.entity.Product;
import io.knoldus.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findByProductId(Long productId) {
        return productRepository.findByProductId(productId);
    }

    public void add(Product product) {
        productRepository.add(product);
    }

    public void delete(Long productId) {
        productRepository.delete(productId);
    }
}
