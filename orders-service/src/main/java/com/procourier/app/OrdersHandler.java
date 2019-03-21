package com.procourier.app;

import spark.Request;
import spark.Response;
import spark.Route;

public class OrdersHandler implements Route {
    public static final OrdersHandler INSTANCE = new OrdersHandler();

    private OrdersHandler() {
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        return null;
    }
}
