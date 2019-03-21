package com.procourier.core.model;

import java.util.Objects;

public final class Product {
    private Long price;
    private String name;
    private String description;
    private Long weight;

    public Product(Long price, String name, String description, Long weight) {
        this.price = Objects.requireNonNull(price);
        this.name = Objects.requireNonNull(name);
        this.description = Objects.requireNonNull(description);
        this.weight = Objects.requireNonNull(weight);
    }

    private static Long checkWeight(Long weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        return Objects.requireNonNull(weight);
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = checkWeight(weight);
    }
}
