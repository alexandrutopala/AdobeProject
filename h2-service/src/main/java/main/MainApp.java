package main;

import com.procourier.model.*;
import org.h2.util.geometry.EWKBUtils;
import service.OrderService;

import java.sql.SQLException;
import java.util.List;

public class MainApp {

    public static void main(String[] args) throws SQLException {
        org.h2.tools.Server.createWebServer("-webPort", "10500").start();

        OrderService service = OrderService.getInstance();
        Product phone = new Product(1000L, "Huawei P30", "new phone", 270L);
        Product laptop = new Product(1500L, "Sony Vayo", "old laptop", 1700L);

        Address emagAddress = new Address("Bucuresti", "Bucuresti", "Virtutii", "20A");
        Address johnAddress = new Address("Craiova", "Dolj", "Ecaterina Teodoroiu", "30A");
        Address courierAddress = new Address("Timisoare", "Timisoara", "AI Cuza", "2C");

        Buyer john = new Buyer("John", johnAddress);
        Seller emag = new Seller("Emag", emagAddress);
        Courier courier = new Courier("ProCourier", courierAddress, 200L, 30L);

        OrderLine olPhone = new OrderLine(phone, 10L);
        OrderLine olLaptop = new OrderLine(laptop, 7L);

        Order order = new Order(emag, john, courier, List.of(olPhone, olLaptop));

        service.addOrder(order);

        System.out.println("Product successfully added");

    }
}
