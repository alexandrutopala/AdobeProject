package com.procourier.app;

import com.procourier.core.model.*;
import com.procourier.repository.CollectionRepository;
import spark.Spark;

import java.util.Map;

public class OrderServiceMain {
    public static void main(String[] args) {
        final var repository = new CollectionRepository();
        final var handler = new OrdersHandler(repository);

        final Address address = new Address("DJ", "Craiova","Lalelelor");
        final Seller seller = new Seller("Evomag", address);

        final Address address1 = new Address("IF", "Buftea","Bucurestilor");
        final Buyer buyer = new Buyer("Cosmin", address1);

        final Address address2 = new Address("B", "Bucuresti","Grivitei");
        final Courier courier = new Courier(1L, "ExpressFan", address2, 5L, 7L);

        final var products = Map.of(
                new Product(20L, "Phone", "bla", 1L), 1
        );

        final Order order = new Order(0L, buyer, seller, courier, products);
        repository.put(order);

        Spark.port(8082);
        Spark.threadPool(25, 10, 2000);
        Spark.get("/orders/:id", handler);
    }
}
