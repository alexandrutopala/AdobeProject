package com.procourier.core.model;

import java.time.Instant;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public final class Order {
    private Long id;
    private Buyer buyer;
    private Seller seller;
    private Courier courier;
    private Instant submittedDate;
    private Map<Product, Integer> orderLines;

    public Order(Long id, Buyer buyer, Seller seller, Courier courier,
                 Instant submittedDate, Map<Product, Integer> orderLines) {
        this.id = Objects.requireNonNull(id);
        this.buyer = Objects.requireNonNull(buyer);
        this.seller = Objects.requireNonNull(seller);
        this.courier = Objects.requireNonNull(courier);
        this.submittedDate = Objects.requireNonNull(submittedDate);
        this.orderLines = Collections.unmodifiableMap(orderLines);
    }

    public Order(Long id, Buyer buyer, Seller seller, Courier courier, Map<Product, Integer> orderLines) {
        this(id, buyer, seller, courier, Instant.now(), orderLines);
    }

    public Long getId() {
        return id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public Courier getCourier() {
        return courier;
    }

    public Instant getSubmittedDate() {
        return submittedDate;
    }

    public Map<Product, Integer> getOrderLines() {
        return orderLines;
    }

    @Override
    public String toString() {
        return id + " " + buyer.getName();
    }
}
