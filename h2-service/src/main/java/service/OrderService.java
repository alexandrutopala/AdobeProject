package service;


import com.procourier.model.Order;
import com.procourier.model.Product;
import dao.OrderDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OrderService {

    private EntityManagerFactory emf;

    private static final class SingletonHolder {
        public static final OrderService SINGLETON = new OrderService();
    }

    private OrderService() {
        emf = Persistence.createEntityManagerFactory("pro-courierPU");
    }

    public static OrderService getInstance() {
        return SingletonHolder.SINGLETON;
    }

    public void addOrder(Order order) {
        EntityManager em = emf.createEntityManager();
        OrderDao dao = new OrderDao(em);

        em.getTransaction().begin();
        dao.addOrder(order);
        em.getTransaction().commit();
    }

    public void addProduct(Product product) {
        EntityManager em = emf.createEntityManager();
        OrderDao dao = new OrderDao(em);

        em.getTransaction().begin();
        dao.addProduct(product);
        em.getTransaction().commit();
    }
}
