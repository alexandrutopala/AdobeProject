package com.procourier.repository;

import com.procourier.core.model.Order;
import com.procourier.core.repository.OrderRepository;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class CollectionRepository implements OrderRepository {
    private final Map<Long, Order> MOCK_ORDERS = new HashMap<>();

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(MOCK_ORDERS.get(id));
    }

    @Override
    public List<Order> getAll() {
        return new ArrayList<>(MOCK_ORDERS.values());
    }

    @Override
    public Long put(Order order) {
        MOCK_ORDERS.put(order.getId(), order);
        return order.getId();
    }

    @Override
    public List<Long> putAll(List<Order> orders) {
        final var ids = orders.stream()
                .map(Order::getId)
                .collect(Collectors.toList());

        final var map = orders.stream()
                .collect(Collectors.toMap(Order::getId, Function.identity()));

        MOCK_ORDERS.putAll(map);

        return ids;

    }
}
