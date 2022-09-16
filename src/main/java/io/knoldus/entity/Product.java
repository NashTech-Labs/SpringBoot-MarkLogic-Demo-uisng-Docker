package io.knoldus.entity;

public class Product {
    private long productId;
    private String name;
    private String description;
    private Double price;

    public Product() {
    }

    public Product(Long productId, String name, String description, Double price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}
