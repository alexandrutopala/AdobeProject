package com.procourier.app;

import com.procourier.core.model.Order;
import com.procourier.core.repository.OrderRepository;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Objects;
import java.util.Optional;

public class OrdersHandler implements Route {
    private final OrderRepository repository;

    public OrdersHandler(OrderRepository repository) {
        this.repository = Objects.requireNonNull(repository);
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        final Long id = Long.parseLong(request.params(":id"));
        final Optional<Order> optionalOrder = repository.findById(id);

        return optionalOrder.map(Order::toString).orElse("Not found");
    }
}
